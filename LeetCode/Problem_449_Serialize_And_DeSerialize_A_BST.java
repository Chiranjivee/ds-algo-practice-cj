/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
     public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder builder = new StringBuilder();
        inorder(root, builder);
        builder.setLength(builder.length() - 1);
        return builder.toString();
    }
    
    public void inorder(TreeNode root, StringBuilder builder) {   
        if (root == null) {
            return;
        }
        
        builder.append(root.val + "-");
        inorder(root.left, builder);
        inorder(root.right, builder);
    }
    

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("")) return null;
        String [] parts = data.split("-");
        
        int [] preorder = new int[parts.length];
        for (int i = 0; i < preorder.length; i++) preorder[i] = Integer.valueOf(parts[i]);
        
        int [] inorder = new int[parts.length];
        for (int i = 0; i < inorder.length; i++) inorder[i] = Integer.valueOf(parts[i]);
        
        Arrays.sort(inorder);
        
        return buildTree(preorder, inorder);
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode buildTree(
        int [] preorder, int pStart, 
        int [] inorder, int iStart, int iEnd) {
        if (pStart >= preorder.length || iStart > iEnd) {
            return null;
        }
        int val = preorder[pStart];
        TreeNode curr = new TreeNode(val);
        
        // find the number of nodes in the left sub tree;
        int n = 0;
        for (int i = iStart; i <= iEnd; i++) {
            if (inorder[i] == val) {
                n = i;
                break;
            }
        }
        
        int numNodesInLeftSubTree = n - iStart;
        curr.left = buildTree(preorder, pStart + 1, inorder, iStart, n - 1);
        curr.right = buildTree(preorder, pStart + 1 + numNodesInLeftSubTree , inorder, n + 1, iEnd);
        return curr;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
