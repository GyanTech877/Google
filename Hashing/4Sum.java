/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
Example :
Given array S = {1 0 -1 0 -2 2}, and target = 0
A solution set is:

    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
    (-1,  0, 0, 1)
Also make sure that the solution set is lexicographically sorted.
Solution[i] < Solution[j] iff Solution[i][0] < Solution[j][0] OR (Solution[i][0] == Solution[j][0] AND ... Solution[i][k] < Solution[j][k])
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(A);
        if(A==null || A.size() ==0) return result;
        return kSum(A,0,B,4);
    }
    private ArrayList<ArrayList<Integer>> kSum(ArrayList<Integer> A, int start,int target,int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(k==2){   
            int low = start;
            int high = A.size()-1;
            while(low<high){
                if((A.get(low)+A.get(high))==target){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(A.get(low));
                    temp.add(A.get(high));
                    result.add(temp);
                    while(low<high && A.get(low)==A.get(low+1)) low++;
                    while(low<high && A.get(high)==A.get(high-1)) high--;
                    low++;
                    high--;
                }
                else if((A.get(low)+A.get(high))>target) high--;
                else low++;
            }
        }
        else{
            for(int i=start;i<A.size()-k+1;i++){
                ArrayList<ArrayList<Integer>> temp = kSum(A,start+1,target-A.get(i),k-1);
                for(ArrayList<Integer> l:temp) {
                    l.add(0,A.get(i));
                }
                result.addAll(temp);
                while(i<A.size()-1 && A.get(i)==A.get(i+1)) i++;
            }
        }
        return result;
    }
}
