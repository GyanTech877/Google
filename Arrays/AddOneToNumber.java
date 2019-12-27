/*
Given a non-negative number represented as an array of digits,

add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

Example:

If the vector has [1, 2, 3]

the returned vector should be [1, 2, 4]

as 123 + 1 = 124.

 NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
For example, for this problem, following are some good questions to ask :
Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
A : For the purpose of this question, YES
Q : Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
*/

public class Solution {
    public int[] plusOne(int[] A) {
        List<Integer> res=new ArrayList();
        if(A == null || A.length ==0) return new int[]{1};
        int start = 0;
        while(start<A.length && A[start]==0) start++;
        int sum = 0;
        int carry = 1;
        for(int i = A.length - 1;i>=start;i--){
            sum=carry+A[i];
            res.add(sum%10);
            carry = sum/10;
        }
        if(carry>0) res.add(carry); 
        int k = res.size() -1;
        int[] result = new int[res.size()];
        int i = 0;
        while(k>=0){
          result[k--] = res.get(i++);
        }
        return result;
    }
}
