class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        
        TreeNode mergedHead = new TreeNode(t1.val + t2.val);
        mergedHead.left = mergeTrees(t1.left, t2.left);
        mergedHead.right = mergeTrees(t1.right, t2.right);
        
        return mergedHead;
    }
}