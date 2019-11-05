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
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> ret = new ArrayList<>();
        
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        int voyageIdx = 0;
        while(!st.isEmpty() && voyageIdx < voyage.length) {
            TreeNode curr = st.pop();
            if (curr.val != voyage[voyageIdx]) {
                break;
            }
            voyageIdx++;
            
            if (voyageIdx < voyage.length) {
                if (curr.left != null && curr.left.val != voyage[voyageIdx]) {
                    ret.add(curr.val);
                    if (curr.left != null) st.push(curr.left);
                    if (curr.right != null) st.push(curr.right);
                } else {
                    if (curr.right != null) st.push(curr.right);
                    if (curr.left != null) st.push(curr.left);
                }
            }
        }
        
        if (voyageIdx != voyage.length) {
            ret.clear();
            ret.add(-1);
            return ret;
        }
        return ret;
    }
}
