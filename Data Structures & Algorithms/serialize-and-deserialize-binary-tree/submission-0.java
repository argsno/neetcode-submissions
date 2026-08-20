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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    
    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        serialize(root.left, sb);
        serialize(root.right, sb);
        sb.append(root.val).append(",");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] list = data.split(",");

        int[] index = new int[1];
        index[0] = list.length - 1;
        return deserialize(list, index);
    }

    private TreeNode deserialize(String[] data, int[] index) {
        if (index[0] < 0 || data[index[0]].equals("#")) {
            index[0]--;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(data[index[0]]));
        index[0] -= 1;
        node.right = deserialize(data, index);
        node.left = deserialize(data, index);
        return node;
    }
}
