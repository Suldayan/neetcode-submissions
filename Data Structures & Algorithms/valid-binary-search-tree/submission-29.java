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
    private boolean isValidNode(final TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }

        final int nodeValue = node.val;
        if (nodeValue <= min || nodeValue >= max) {
            return false;
        }

        final boolean isLeftValid = isValidNode(node.left, min, nodeValue);
        final boolean isRightValid = isValidNode(node.right, nodeValue, max);

        return isLeftValid && isRightValid;
    }

    public boolean isValidBST(TreeNode root) {
        return isValidNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
