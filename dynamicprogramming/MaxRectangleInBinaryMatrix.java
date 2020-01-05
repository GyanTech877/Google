/*
Given a 2D binary matrix filled with 0’s and 1’s, find the largest rectangle containing all ones and return its area.

Bonus if you can solve it in O(n^2) or less.

Example :

A : [  1 1 1
       0 1 1
       1 0 0 
    ]

Output : 4 

As the max area rectangle is created by the 2x2 rectangle created by (0,1), (0,2), (1,1) and 
*/

public class Solution {
    public int maximalRectangle(int[][] A) {
        if(A==null || A.length ==0) return 0;
        int m = A.length;
        int n = A[0].length;
        int[] input = new int[n];
        for(int j=0;j<n;j++){
            input[j] = A[0][j];
        }
        int maxArea = findMaxArea(input);
        for(int i=1;i<m;i++){
           for(int j=0;j<n;j++){
                if(A[i][j]==0) input[j] = 0;
                else input[j] += A[i][j];
            } 
            maxArea = Math.max(maxArea,findMaxArea(input));
        }
        return maxArea;
    }
    private int findMaxArea(int[] input){
        int maxArea = 0;
        int i=0;
        Stack<Integer> stack = new Stack<>();
        while(i<input.length){
            if(stack.isEmpty() || input[stack.peek()]<=input[i]) stack.push(i++);
            else{
                int top = stack.pop();
                if(stack.isEmpty()) maxArea = Math.max(maxArea,input[top]*i);
                else{
                    maxArea = Math.max(maxArea,input[top]*(i-stack.peek()-1));
                }
            }
        }
        while(!stack.isEmpty()){
            int top = stack.pop();
            if(stack.isEmpty()) maxArea = Math.max(maxArea,input[top]*i);
            else{
                maxArea = Math.max(maxArea,input[top]*(i-stack.peek()-1));
            }
        }
        return maxArea;
    }
}
