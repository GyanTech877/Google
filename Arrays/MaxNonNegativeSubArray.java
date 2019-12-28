/*
Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.

The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

Maximum sub-array is defined in terms of the sum of the elements in the sub-array.

Find and return the required subarray.

NOTE:

    1. If there is a tie, then compare with segment's length and return segment which has maximum length.
    2. If there is still a tie, then return the segment with minimum starting index.


Input Format:

The first and the only argument of input contains an integer array A, of length N.
Output Format:

Return an array of integers, that is a subarray of A that satisfies the given conditions.
Constraints:

1 <= N <= 1e5
1 <= A[i] <= 1e5
Examples:

Input 1:
    A = [1, 2, 5, -7, 2, 3]

Output 1:
    [1, 2, 5]

Explanation 1:
    The two sub-arrays are [1, 2, 5] [2, 3].
    The answer is [1, 2, 5] as its sum is larger than [2, 3].

Input 2:
    A = [10, -1, 2, 3, -4, 100]
    
Output 2:
    [100]

Explanation 2:
    The three sub-arrays are [10], [2, 3], [100].
    The answer is [100] as its sum is larger than the other two.
 */
 
 public class Solution {
    public int[] maxset(int[] A) {
        if(A == null || A.length ==0) return new int[]{};
        long currSum = 0;
        long golbalSum = 0;
        int maxI=0;
        int maxJ=0;
        int currI=0;
        for(int i=0;i<A.length;i++){
            if(A[i]>=0){
                currSum+=A[i];
                if((currSum>golbalSum) ||((currSum==golbalSum) 
                && ((i-currI)>(maxJ-maxI)))){
                   maxI = currI;
                   maxJ = i; 
                   golbalSum = currSum;
                }
            }
            else{
              currI = i+1;
              currSum = 0;
            }
        }
        if(maxJ==maxI && A[maxJ]<0)  return new int[]{};
        int [] res = new int[maxJ-maxI+1];
        for(int i=maxI;i<=maxJ;i++){
            res[i-maxI] = A[i];
        }
        return res;
    }
}
