/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers % 1003.

Example :

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = (12 + 13) % 1003 = 25 % 1003 = 25.
*/

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
 
public class Solution {
    int mod = 1003;
    public int sumNumbers(TreeNode A) {
        if(A==null) return 0;
        int res = 0;
        List<Integer> result = new ArrayList<>();
        recur(A,result,A.val);
        for(Integer i:result){
            res=(res%mod+i%mod)%mod;
        }
        return res;
    }
    private void recur(TreeNode A,List<Integer> result,int currSum){
        if(A.left==null && A.right==null) {
            result.add(currSum);
            return;
        }
        if(A.left!=null){
            int newLeftSum = (currSum*10%mod + A.left.val)%mod;
            recur(A.left,result,newLeftSum);
        }
        if(A.right!=null){
            int newRightSum = (currSum*10%mod + A.right.val)%mod;
            recur(A.right,result,newRightSum);
        }
    }
}
