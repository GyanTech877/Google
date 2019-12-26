/*
Given an index k, return the kth row of the Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Input : k = 3

Return : [1,3,3,1]
*/

public class Solution {
    public ArrayList<Integer> getRow(int A) {
           ArrayList<Integer>  result = new ArrayList<>();
           if(A<0) return result;
           for(int i=1;i<=A;i++){
              for(int j = result.size()-2;j>=0;j--){
                  result.set(j+1,result.get(j)+result.get(j+1));
              }
              result.add(1);
           }
    }
}
