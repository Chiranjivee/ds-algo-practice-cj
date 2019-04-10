/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, PriorityQueue<Node>> map = new TreeMap<>();
        verticalTraversalUtil(root, 0, 0, map);
        List<List<Integer>> result = new ArrayList<>();
        
        for (Map.Entry<Integer, PriorityQueue<Node>> entry : map.entrySet()) {
            List<Integer> temp = new ArrayList<>();
            PriorityQueue<Node> pq = entry.getValue();
            while (!pq.isEmpty()) temp.add(pq.poll().val);
            result.add(temp);
        }
        return result;
    }
    
    public void verticalTraversalUtil(TreeNode root, int leftOrRight, int level, TreeMap<Integer, PriorityQueue<Node>> map) {
        if (root == null) {
            return;
        }
        
        if (map.containsKey(leftOrRight)) {
            PriorityQueue<Node> myQueue = map.get(leftOrRight);
            myQueue.add(new Node(root.val, level));
            map.put(leftOrRight, myQueue);
        } else {
            PriorityQueue<Node> myQueue = new PriorityQueue<>(11, (a, b) -> {
                if (a.level == b.level) {
                    return a.val - b.val;
                } else {
                    return b.level - a.level;
                }
            });
            myQueue.add(new Node(root.val, level));
            map.put(leftOrRight, myQueue);
        }
        
        verticalTraversalUtil(root.left, leftOrRight - 1, level - 1, map);
        verticalTraversalUtil(root.right, leftOrRight + 1, level - 1, map);
    }
    
}

class Node {
    int level;
    int val;
    
    public Node(int val, int level) {
        this.val = val;
        this.level = level;
    }
}
