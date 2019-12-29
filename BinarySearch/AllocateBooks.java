/*
Given an array of integers A of size N and an integer B.

College library has N bags,the ith book has A[i] number of pages.

You have to allocate books to B number of students so that maximum number of pages alloted to a student is minimum.

A book will be allocated to exactly one student.
Each student has to be allocated at least one book.
Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
Calculate and return that minimum possible number.

NOTE: Return -1 if a valid assignment is not possible.



Input Format

The first argument given is the integer array A.
The second argument given is the integer B.
Output Format

Return that minimum possible number
Constraints

1 <= N <= 10^5
1 <= A[i] <= 10^5
For Example

Input 1:
    A = [12, 34, 67, 90]
    B = 2
Output 1:
    113
Explanation 1:
    There are 2 number of students. Books can be distributed in following fashion : 
        1) [12] and [34, 67, 90]
        Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
        2) [12, 34] and [67, 90]
        Max number of pages is allocated to student 2 with 67 + 90 = 157 pages 
        3) [12, 34, 67] and [90]
        Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages

        Of the 3 cases, Option 3 has the minimum pages = 113.

Input 2:
    A = [5, 17, 100, 11]
    B = 4
Output 2:
    100
 */
 
 public class Solution {
    public int books(int[] A, int B) {
        if(A==null || A.length ==0 || B>A.length) return -1;
        int result = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        for(int i=0;i<A.length;i++){
            end+=A[i];
        }
        while(start<=end){
            int mid = start + (end-start)/2;
            if(isPossible(A,mid,B)){
                result = Math.min(result,mid);
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return result;
    }
    private boolean isPossible(int[] A,int maxValue,int applicableNoOfStudents){
        int maxNoOfStudents = 1;
        int currSum = 0;
        for(int i = 0;i<A.length;i++){
            if(A[i]>maxValue) return false;
            if((currSum+A[i])>maxValue){
                maxNoOfStudents++;
                currSum = A[i];
                if(maxNoOfStudents>applicableNoOfStudents) return false;
            }
            else currSum+=A[i];
        }
        return true;
    }
}
 
