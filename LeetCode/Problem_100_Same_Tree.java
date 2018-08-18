class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null) return false;
        if (q == null) return false;
        
        boolean isRootSame = (p.val == q.val);
        if (!isRootSame) return false;
        
        boolean checkLeftSubTree = isSameTree(p.left, q.left);
        boolean checkRightSubTree = isSameTree(p.right, q.right);
        
        return checkLeftSubTree && checkRightSubTree;
    }
}