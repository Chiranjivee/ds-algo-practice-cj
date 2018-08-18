/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        // depth of current level 
        // 1 + max(depth_of_each_children)
        
        int depth = 1;
        if (root.children == null || root.children.size() == 0) {
            return depth;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < root.children.size(); i++) {
            if (root.children.get(i) != null) {
                max = Math.max(max, maxDepth(root.children.get(i)));
            }
        }

        return depth + max;
    }
}
