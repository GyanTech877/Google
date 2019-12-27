/*
Given numRows, generate the first numRows of Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Given numRows = 5,

Return

[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        curr.add(1);
        ArrayList<Integer> prev;
        for(int i=0;i<A;i++){
            result.add(new ArrayList<>(curr));
            prev = new ArrayList<>(curr);
            for(int j=0;j<prev.size()-1;j++){
                curr.set(j+1,prev.get(j)+prev.get(j+1));
            }
            curr.add(1);
        }
        return result;
    }
}
