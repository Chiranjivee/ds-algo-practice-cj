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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) addLevel(result, 0, root);
        return result;
    }
    
    public void addLevel(List<List<Integer>> result, int level, Node root) {
        if (root == null) return;
        if (level >= result.size()) {
            result.add(new LinkedList<Integer>());
        }
        result.get(level).add(root.val);
        for (Node child : root.children)
        addLevel(result, level + 1, child);
    }
}
