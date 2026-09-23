/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    long second=Long.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        int min=root.val;
        dfs(root,min);
        if(second==Long.MAX_VALUE){
            return -1;
        }
        return (int) second;
    }
    private void dfs(TreeNode root,int min){
        if(root==null){
            return;
        }
        if(root.val>min && root.val<second){
            second=root.val;
        }
        dfs(root.left,min);
        dfs(root.right,min);
    }
}
