/*
Find the intersection of two sorted arrays.
OR in other words,
Given 2 sorted arrays, find all the elements which occur in both the arrays.

Example :

Input : 
    A : [1 2 3 3 4 5 6]
    B : [3 3 5]

Output : [3 3 5]

Input : 
    A : [1 2 3 3 4 5 6]
    B : [3 5]

Output : [3 5]
 NOTE : For the purpose of this problem ( as also conveyed by the sample case ), assume that elements that appear more than once in both arrays should be included multiple times in the final output.
 */
 
 public class Solution {
    public int[] intersect(final int[] A, final int[] B) {
        List<Integer> result = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<A.length && j<B.length){
            if(A[i]==B[j]){
                result.add(A[i]);
                i++;
                j++;
            }
            else if(A[i]<B[j]) i++;
            else j++;
        }
       int[] res = new int[result.size()];
       for(int k=0;k<res.length;k++)
           res[k]=result.get(k);
        return res;
    }
}
