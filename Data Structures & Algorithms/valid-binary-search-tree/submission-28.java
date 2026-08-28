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

        if (node.val <= min || node.val >= max) {
            return false;
        }

        final boolean isLeftValid = isValidNode(
            node.left, 
            min, 
            node.val);

        final boolean isRightValid = isValidNode(
            node.right, 
            node.val, 
            max);

        return isLeftValid && isRightValid;
    }

    public boolean isValidBST(TreeNode root) {
        return isValidNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
