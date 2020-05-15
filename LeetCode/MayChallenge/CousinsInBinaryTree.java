/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root, -1, 0));

        boolean foundX = false;
        boolean foundY = false;
        
        int pX = -1;
        int pY = -1;
        int lX = -1;
        int lY = -1;
        
        while (!queue.isEmpty()) {

            Node current = queue.poll();

            if (current.n.val == x) {
                pX = current.parent;
                lX = current.level;
                foundX = true;
            }
            
            if (current.n.val == y) {
                pY = current.parent;
                lY = current.level;
                foundY = true;
            }
            
            if (foundX && foundY) {
                if (pX != pY && lX == lY) {
                    return true;
                } else {
                    pX = -1;
                    pY = -1;
                    foundX = false;
                    foundX = false;
                }
            }
            
            
            if (current.n.left != null) {
                queue.offer(
                    new Node(
                        current.n.left, 
                        current.n.val, 
                        current.level + 1));
            }
            
            if (current.n.right != null) {
                queue.offer(
                    new Node(
                        current.n.right, 
                        current.n.val, 
                        current.level + 1));
            }
        }
        
        return false;
    }
}

class Node {
    TreeNode n;
    int parent;
    int level;
    
    public Node(TreeNode n, int parent, int level) {
        this.n = n;
        this.parent = parent;
        this.level = level;
    }
}
