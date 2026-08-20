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

    boolean isMatched = false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        long targetHash = computeHash(subRoot, null);
        computeHash(root, targetHash);
        return isMatched;
    }

    private long computeHash(TreeNode root, Long targetHash) {
        if (root == null) return 1L;

        long leftHash = computeHash(root.left, targetHash);
        long rightHash = computeHash(root.right, targetHash);

        long hash = Objects.hash(root.val, leftHash, rightHash);

        if (targetHash != null && hash == targetHash) {
            isMatched = true;
        }
        return hash;
    }
}
