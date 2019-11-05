/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }

        String ans = String.valueOf(t.val);
        String leftResult = tree2str(t.left);
        String rightResult = tree2str(t.right);
        if (!leftResult.equals("")) {
            ans += "(" + leftResult + ")";
        }

        if (!rightResult.equals("")) {
            if (leftResult.equals(""))
                ans += "()";
            ans += "(" + rightResult + ")";
        }

        return ans;
    }
}
