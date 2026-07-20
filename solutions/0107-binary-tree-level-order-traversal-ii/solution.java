class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> wrapList = new ArrayList<>();

        if (root == null)
            return wrapList;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int levelNum = queue.size();
            List<Integer> subList = new ArrayList<>();

            for (int i = 0; i < levelNum; i++) {

                TreeNode node = queue.poll();

                subList.add(node.val);

                if (node.left != null)
                    queue.offer(node.left);

                if (node.right != null)
                    queue.offer(node.right);
            }

            wrapList.add(subList);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = wrapList.size() - 1; i >= 0; i--) {
            ans.add(wrapList.get(i));
        }

        return ans;
    }
}
