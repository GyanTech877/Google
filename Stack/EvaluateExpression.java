/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.



Input Format

The only argument given is character array A.
Output Format

Return the value of arithmetic expression formed using reverse Polish Notation.
For Example

Input 1:
    A =   ["2", "1", "+", "3", "*"]
Output 1:
    9
Explaination 1:
    starting from backside:
    *: ( )*( )
    3: ()*(3)
    +: ( () + () )*(3)
    1: ( () + (1) )*(3)
    2: ( (2) + (1) )*(3)
    ((2)+(1))*(3) = 9
    
Input 2:
    A = ["4", "13", "5", "/", "+"]
Output 2:
    6
Explaination 2:
    +: ()+()
    /: ()+(() / ())
    5: ()+(() / (5))
    1: ()+((13) / (5))
    4: (4)+((13) / (5))
    (4)+((13) / (5)) = 6
  */
  
  public class Solution {
    public int evalRPN(String[] A) {
        if(A==null || A.length ==0) return 0;
        Stack<String> stack = new Stack<>();
        for(int i=0;i<A.length;i++){
            if(A[i].equals("+") || A[i].equals("-") || A[i].equals("*") || A[i].equals("/")){
                int first = Integer.parseInt(stack.pop());
                int second = Integer.parseInt(stack.pop());
                int result = 0;
                if(A[i].equals("+")) result = second+first;
                else if(A[i].equals("-")) result = second-first;
                else if(A[i].equals("*")) result = second*first;
                else result = second/first;
                stack.push(String.valueOf(result));
            }
            else stack.push(A[i]);
        }
        return Integer.parseInt(stack.pop());
    }
}
