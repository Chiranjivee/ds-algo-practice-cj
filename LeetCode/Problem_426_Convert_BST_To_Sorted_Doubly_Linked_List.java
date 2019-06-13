/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    Node first;
    Node last;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        
        helper(root);
        last.right = first;
        first.left = last;
        return first;
    }
    
    public void helper(Node root) {
        if (root == null) return;
        
        helper(root.left);
        if (last != null) {
            // link the previous node with current one
            last.right = root;
            root.left = last;
        } else { 
            first = root;
        }
        
        last = root;
        helper(root.right);
    }
}
