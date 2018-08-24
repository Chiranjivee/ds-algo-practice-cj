/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode current = st.peek();
            if (current.left != null) {
                st.push(current.left);
                continue;
            }
            
            current = st.pop();
            result.add(current.val);
            if (current.right != null) {
                st.push(current.right);   
            } else {
                while (!st.isEmpty()) {
                    current = st.pop();
                    result.add(current.val);
                    if (current.right != null) {
                        st.push(current.right);   
                        break;
                    }
                }
            }
        }
        
        return result;
    }
}
