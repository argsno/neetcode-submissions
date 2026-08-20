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
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left, 0);
        int right = maxDepth(root.right, 0);
        ans = Math.max(ans, left+right);
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return ans;
    }

    private int maxDepth(TreeNode root, int level) {
        if (root == null) return level;
        int left = maxDepth(root.left, level+1);
        int right = maxDepth(root.right, level+1);
        return Math.max(left, right);
    }
}
