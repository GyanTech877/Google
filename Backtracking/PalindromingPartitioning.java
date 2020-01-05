/*
Given a string s, partition s such that every string of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["a","a","b"]
    ["aa","b"],
  ]
 Ordering the results in the answer : Entry i will come before Entry j if :
len(Entryi[0]) < len(Entryj[0]) OR
(len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR
*
*
*
(len(Entryi[0]) == len(Entryj[0]) AND … len(Entryi[k] < len(Entryj[k]))
In the given example,
["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa")
*/

public class Solution {
    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        backTrack(a,result,new ArrayList<>(),0);
        return result;
    }
    private void backTrack(String input,ArrayList<ArrayList<String>> result,List<String> curr,int start){
        if(start==input.length()){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i=start+1;i<=input.length();i++){
            if(isPalindrome(input,start,i-1)){
                curr.add(input.substring(start,i));
                backTrack(input,result,curr,i);
                curr.remove(curr.size()-1);
            }
        }
    }
    private boolean isPalindrome(String input,int l,int h){
        while(l<h){
            if(input.charAt(l++)!=input.charAt(h--)) return false;
        }
        return true;
    }
}
