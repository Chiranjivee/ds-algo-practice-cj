class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null) return false;
        if (root2 == null) return false;
        
        List<Integer> tree1LeafSeq = new ArrayList<>();
        List<Integer> tree2LeafSeq = new ArrayList<>();
        
        populateTreeLeafSeq(root1, tree1LeafSeq);
        populateTreeLeafSeq(root2, tree2LeafSeq);
        
        if (tree1LeafSeq.size() != tree2LeafSeq.size()) return false;
        
        for (int i = 0; i < tree1LeafSeq.size(); i++) {
            if (tree1LeafSeq.get(i) != tree2LeafSeq.get(i)) return false;
        }
            
        return true;
        
    }
    
    public void populateTreeLeafSeq(TreeNode root, List<Integer> leafSeq) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leafSeq.add(root.val);
            return;
        }
        populateTreeLeafSeq(root.left, leafSeq);
        populateTreeLeafSeq(root.right, leafSeq);
    }
}