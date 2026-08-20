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
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < l; i++) {
            inMap.put(inorder[i], i);
        }
        return build(preorder, 0, l-1, inorder, 0, l-1, inMap);
    }

    private TreeNode build(int[] pre, int ps, int pe, int[] in, int is, int ie, Map<Integer, Integer> inMap) {
        if (ps > pe) {
            return null;
        }
        int v = pre[ps];
        TreeNode root = new TreeNode(v);

        int i = inMap.get(v);

        int leftCount = i - is;
        
        root.left = build(pre, ps+1, ps+leftCount, in, is, i-1, inMap);
        root.right = build(pre, ps+leftCount+1, pe, in, i+1, ie, inMap);
        return root;
    }
}
