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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int l = preorder.length;
        return build(preorder, 0, l-1, inorder, 0, l-1);
    }

    private TreeNode build(int[] pre, int ps, int pe, int[] in, int is, int ie) {
        if (ps > pe) {
            return null;
        }
        int v = pre[ps];
        TreeNode root = new TreeNode(v);

        int i = is;
        for (; i <= ie; i++) {
            if (in[i] == v) break;
        }

        int leftCount = i - is;
        
        root.left = build(pre, ps+1, ps+leftCount, in, is, i-1);
        root.right = build(pre, ps+leftCount+1, pe, in, i+1, ie);
        return root;
    }
}
