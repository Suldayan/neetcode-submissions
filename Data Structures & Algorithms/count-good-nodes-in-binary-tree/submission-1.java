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
    private int findGoodNodes(final TreeNode node, int currentMax) {
        if (node == null) {
            return 0;
        }
        final int isGood = (node.val >= currentMax) ? 1 : 0;
        currentMax = Math.max(currentMax, node.val);

        final int left = findGoodNodes(node.left, currentMax);
        final int right = findGoodNodes(node.right, currentMax);

        return isGood + left + right;
    }

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return findGoodNodes(root, root.val);
    }
}
