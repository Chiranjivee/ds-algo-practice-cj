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
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        if (root.children == null) {
            result.add(root.val);
            return result;
        }
        
        
        for (Node child : root.children) {
            result.addAll(postorder(child));
        }
        result.add(root.val);
        return result;
    }
}
