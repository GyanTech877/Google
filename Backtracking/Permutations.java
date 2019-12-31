/*
Given a collection of numbers, return all possible permutations.

Example:

[1,2,3] will have the following permutations:

[1,2,3]
[1,3,2]
[2,1,3] 
[2,3,1] 
[3,1,2] 
[3,2,1]
 NOTE
No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
 Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points. 
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean[] used=new boolean[A.size()];
        backTrack(A,new ArrayList<>(),result,used);
        return result;
    }
    private static void backTrack(ArrayList<Integer> A,ArrayList<Integer> curr,
    ArrayList<ArrayList<Integer>> result,boolean[] used){
        if(curr.size()==A.size()){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<A.size();i++){
            if(used[i]) continue;
            used[i]=true;
            curr.add(A.get(i));
            backTrack(A,curr,result,used);
            curr.remove(curr.size()-1);
            used[i]=false;
        }
    }
}
