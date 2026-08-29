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
    private TreeNode kthNode;
    private int counter = 0;

    private void traverse(final TreeNode node, final int k) {
        if (node == null || kthNode != null) {
            return;
        }

        traverse(node.left, k);

        counter++;
        if (counter == k) {
            kthNode = node;
            return;
        } 

        traverse(node.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        traverse(root, k);
        return kthNode.val;
    }
}
