/*
Given an array of integers A. There is a sliding window of size B which
is moving from the very left of the array to the very right.
You can only see the w numbers in the window. Each time the sliding window moves
rightwards by one position. You have to find the maximum for each window.
The following example will give you more clarity.

The array A is [1 3 -1 -3 5 3 6 7], and B is 3.

Window position	Max
———————————-	————————-
[1 3 -1] -3 5 3 6 7	3
1 [3 -1 -3] 5 3 6 7	3
1 3 [-1 -3 5] 3 6 7	5
1 3 -1 [-3 5 3] 6 7	5
1 3 -1 -3 [5 3 6] 7	6
1 3 -1 -3 5 [3 6 7]	7
Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1].

Note: If B > length of the array, return 1 element with the max of the array.



Input Format

The first argument given is the integer array A.
The second argument given is the integer B.
Output Format

Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1]
For Example

Input 1:
    A = [1, 3, -1, -3, 5, 3, 6, 7]
    B = 3
Output 1:
    C = [3, 3, 5, 5, 6, 7]
 */
 public class Solution {
    public int[] slidingMaximum(final int[] A, int B) {
        if(A == null || A.length == 0) return new int[]{};
        int n = A.length;
        int[] result = new int[n-B+1];
        Deque<Integer> window = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(!window.isEmpty() && i-B == window.peek()) window.poll();
            while(!window.isEmpty() && A[i]>A[window.peek()]) window.pollLast();
            window.offer(i);
            if(i-B+1>=0)
            result[i-B+1] = A[window.peek()];
        }
        return result;
    }
}
