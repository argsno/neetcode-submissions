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
    public boolean isBalanced(TreeNode root) {
        return helper(root).balance;
    }

    class Entry {
        int depth;
        boolean balance;

        Entry(int d, boolean b) {
            depth = d;
            balance = b;
        }
    }

    private Entry helper(TreeNode root) {
        if (root == null) return new Entry(0, true);

        Entry left = helper(root.left);
        Entry right = helper(root.right);
        boolean balance = left.balance && right.balance && Math.abs(left.depth - right.depth) <= 1;
        int depth = Math.max(left.depth, right.depth) + 1;
        return new Entry(depth, balance);
    }
}
