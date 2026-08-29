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
    private void traverse(final TreeNode node, int depth, List<Integer> list) {
        if (node == null) {
            return;
        }

        if (depth == list.size()) {
            list.add(node.val);  
        }

        traverse(node.right, depth + 1, list);
        traverse(node.left, depth + 1, list);
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return List.of();
        }

        List<Integer> list = new ArrayList<>();
        traverse(root, 0, list);
        return list;
    }
}
