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
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        if (root.children == null) {
            result.add(root.val);
            return result;
        }
        
        result.add(root.val);
        for (Node child : root.children) {
            result.addAll(preorder(child));
        }
        
        return result;
    }
}
