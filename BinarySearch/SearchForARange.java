/*
Given a sorted array of integers A(0 based index) of size N, find the starting and ending position of a given integar B in array A.

Your algorithm’s runtime complexity must be in the order of O(log n).

Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].



Input Format

The first argument given is the integer array A.
The second argument given is the integer B.
Output Format

 Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].
Constraints

1 <= N <= 10^6
1 <= A[i], B <= 10^9
For Example

Input 1:
    A = [5, 7, 7, 8, 8, 10]
    B = 8
Output 1:
    [3, 4]
Explanation 1:
    First occurence of 8 in A is at index 3
    Second occurence of 8 in A is at index 4
    ans = [3, 4]

Input 2:
    A = [5, 17, 100, 111]
    B = 3
Output 2:
    [-1, -1]
 */
 
 public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] searchRange(final int[] A, int B) {
        int[] result = new int[]{-1,-1};
        if(A==null || A.length==0) return result;
        result[0]=findIndex(A,B,true);
        result[1]=findIndex(A,B,false);
        return result;
    }
    private int findIndex(int[] A,int B,boolean first){
        int start = 0;
        int end = A.length - 1 ;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(A[mid]==B){
                if(first){
                    if(mid==0 || A[mid-1]!=A[mid]) return mid;
                    end = mid-1;
                }
                else{
                    if(mid==end || A[mid+1]!=A[mid]) return mid;
                    start = mid+1;
                }
            }
            else if(A[mid]<B){
                start = mid+1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }
}
