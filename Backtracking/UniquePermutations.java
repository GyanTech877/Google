/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example :
[1,1,2] have the following unique permutations:

[1,1,2]
[1,2,1]
[2,1,1]
 NOTE : No 2 entries in the permutation sequence should be the same. 
 Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points. 
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(A);
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
            if(used[i] || (i>0 && A.get(i)==A.get(i-1) && !used[i-1])) continue;
            used[i]=true;
            curr.add(A.get(i));
            backTrack(A,curr,result,used);
            curr.remove(curr.size()-1);
            used[i]=false;
        }
    }
}
