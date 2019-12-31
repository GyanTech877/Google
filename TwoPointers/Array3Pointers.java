/*
You are given 3 arrays A, B and C. All 3 of the arrays are sorted.

Find i, j, k such that :
max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))

**abs(x) is absolute value of x and is implemented in the following manner : **

      if (x < 0) return -x;
      else return x;
Example :

Input : 
        A : [1, 4, 10]
        B : [2, 15, 20]
        C : [10, 12]

Output : 5 
         With 10 from A, 15 from B and 10 from C. 
*/

public class Solution {
    public int minimize(final int[] A, final int[] B, final int[] C) {
       int i=0;
       int j=0;
       int k=0;
       int minDiff = Integer.MAX_VALUE;
       while(i<A.length && j<B.length && k<C.length){
           int maximum = Math.max(A[i],Math.max(B[j],C[k])); 
           int minimum = Math.min(A[i],Math.min(B[j],C[k])); 
           minDiff = Math.min(minDiff,Math.abs(maximum-minimum));
           if(minimum==A[i]) i++;
           else if(minimum==B[j]) j++;
           else k++;
       }
       return minDiff;
    }
}
