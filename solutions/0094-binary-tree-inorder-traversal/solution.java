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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> tree=new Stack<>();
        List<Integer> result=new ArrayList<>();
        TreeNode temp=root;
        while(true){
            if(temp!=null){
                tree.push(temp);
                temp=temp.left;
            }else{
                if(tree.isEmpty()){
                    break;
                }
                temp=tree.pop();
                result.add(temp.val);
                temp=temp.right;
                
            }

            
        }
        return result;

    }
}
