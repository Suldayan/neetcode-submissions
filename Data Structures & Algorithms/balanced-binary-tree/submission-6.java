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
    private int getHeight(final TreeNode node) {
        if (node == null) {
            return 0;
        }

        final int leftHeight = getHeight(node.left);
        final int rightHeight = getHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        final int leftHeight = getHeight(root.left);
        final int rightHeight = getHeight(root.right);
        final boolean isBalanced = Math.abs(leftHeight - rightHeight) <= 1;
        
        return isBalanced && isBalanced(root.left) && isBalanced(root.right);
    }
}
