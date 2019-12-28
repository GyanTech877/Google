/*
Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].

If there is no solution possible, return -1.

Example :

A : [3 5 4 2]

Output : 2 
for the pair (3, 4)
*/

public class Solution {
    public int maximumGap(final int[] A) {
        if(A == null || A.length ==0) return -1;
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        left[0] = A[0];
        for(int i=1;i<A.length;i++){
            left[i] = Math.min(A[i],left[i-1]);
        }
        right[A.length-1] = A[A.length-1];
        for(int j= A.length-2;j>=0;j--){
            right[j] = Math.max(A[j],right[j+1]);
        }
        int result = 0;
        int i = 0;
        int j = 0;
        while(i<A.length && j<A.length){
            if(left[i]<=right[j]){
                if(i<j){
                    result = Math.max(result,j-i);
                    j++;
                }
                else j = i+1;
            }
            else{
                i++;
            }
        }
        return result;
    }
}
