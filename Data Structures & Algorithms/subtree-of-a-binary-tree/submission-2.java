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
    private static final long P1 = 31L;
    private static final long P2 = 37L;
    private static final long P3 = 41L;
    private static final long MOD = 1000000007L;

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

        long hash = (root.val * P1 % MOD + leftHash * P2 % MOD + rightHash * P3 % MOD) % MOD;

        if (targetHash != null && hash == targetHash) {
            isMatched = true;
        }
        return hash;
    }
}
