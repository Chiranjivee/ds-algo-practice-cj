/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class CBTInserter {
    TreeNode root;
    ArrayList<TreeNode> list = new ArrayList<>();
    public CBTInserter(TreeNode root) {
        this.root = root;
        list.add(root);
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i).left != null) list.add(list.get(i).left);
            if (list.get(i).right != null) list.add(list.get(i).right);
        }
    }
    
    public int insert(int v) {
        int N = list.size();
        TreeNode node = new TreeNode(v);
        list.add(node);
        
        if (N % 2 == 1) {
            list.get((N - 1)/2).left = node;
        } else {
            list.get((N - 1)/2).right = node;
        }
        
        return list.get((N - 1) / 2).val;
    }
    
    public TreeNode get_root() {
        return this.list.get(0);
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */
