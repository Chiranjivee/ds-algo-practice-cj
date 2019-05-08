/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    private GNode targetGNode;

    private class GNode {
        TreeNode node;
        GNode parent, left, right;

        GNode(TreeNode node) {
            this.node = node;
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null || K < 0)
            return res;
        cloneGraph(root, null, target);
        if (targetGNode == null)
            return res;
        Set<GNode> visited = new HashSet<GNode>();
        Queue<GNode> q = new LinkedList<GNode>();
        q.add(targetGNode);
        visited.add(targetGNode);
        while (!q.isEmpty()) {
            int size = q.size();
            if (K == 0) {
                for (int i = 0; i < size; i++)
                    res.add(q.poll().node.val);
                return res;
            }
            for (int i = 0; i < size; i++) {
                GNode gNode = q.poll();
                if (gNode.left != null && !visited.contains(gNode.left)) {
                    visited.add(gNode.left);
                    q.add(gNode.left);
                }
                if (gNode.right != null && !visited.contains(gNode.right)) {
                    visited.add(gNode.right);
                    q.add(gNode.right);
                }
                if (gNode.parent != null && !visited.contains(gNode.parent)) {
                    visited.add(gNode.parent);
                    q.add(gNode.parent);
                }
            }
            K--;
        }
        return res;
    }

    private GNode cloneGraph(TreeNode node, GNode parent, TreeNode target) {
        if (node == null)
            return null;
        GNode gNode = new GNode(node);
        if (node == target)
            targetGNode = gNode;
        gNode.parent = parent;
        gNode.left = cloneGraph(node.left, gNode, target);
        gNode.right = cloneGraph(node.right, gNode, target);
        return gNode;
    }
}
