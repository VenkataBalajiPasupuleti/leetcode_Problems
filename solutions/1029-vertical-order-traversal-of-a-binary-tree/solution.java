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
    class NodeInfo{
        int row;
        int column;
        int value;
        NodeInfo(int row,int column,int value){
            this.row=row;
            this.column=column;
            this.value=value;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //step-1 traverse each node and save Info
        List<NodeInfo> nodes=new ArrayList<>();
        dfs(root,0,0,nodes);

        //step-2 sort nodes
        nodes.sort((a,b)->{
            if(a.column!=b.column){
                return Integer.compare(a.column,b.column);
            }

            if(a.row!=b.row){
                return Integer.compare(a.row,b.row);
            }
            return Integer.compare(a.value,b.value);
        });

        //step-3 group them 
        List<List<Integer>> result=new ArrayList<>();
        int previousColumn=Integer.MIN_VALUE;
        for(NodeInfo node:nodes){
            if(node.column!=previousColumn){
                result.add(new ArrayList<>());
                previousColumn=node.column;
            }
            result.get(result.size()-1).add(node.value);
        }

        return result;

    }

    private void dfs(TreeNode root,int row,int column,List<NodeInfo> nodes){
        if(root==null){
            return;
        }

        dfs(root.left,row+1,column-1,nodes);
        nodes.add(new NodeInfo(row,column,root.val));
        dfs(root.right,row+1,column+1,nodes);
    }
}
