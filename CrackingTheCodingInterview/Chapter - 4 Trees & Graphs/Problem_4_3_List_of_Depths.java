import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Problem 4.3: List of depths
 * 
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth (e.g., if 
 * you have a tree with depth D, you'll have D linked lists.)
 * 
 */
class Solution {
    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public TreeNode buildTree() {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(8);
        TreeNode node5 = new TreeNode(10);
        TreeNode node6 = new TreeNode(15);
        TreeNode node7 = new TreeNode(90);

        root.left = node1;
        root.right = node2;

        root.left.left = node3;
        root.left.right = node4;

        root.right.left = node5;
        root.right.right = node6;

        root.right.left.right = node7;

        return root;
    }

    public void createLevelLinkedList(int level, TreeNode node, ArrayList<LinkedList<TreeNode>> myList) {
        if (node == null) return;
        LinkedList<TreeNode> currList = level == myList.size() ? new LinkedList<>() : myList.get(level);

        currList.add(node);
        createLevelLinkedList(level + 1, node.left, myList);
        createLevelLinkedList(level + 1, node.right, myList);
    }

    public void execute() {
        ArrayList<LinkedList<TreeNode>> myList = new ArrayList<>();
        TreeNode root = buildTree();
        createLevelLinkedList(0, root, myList);
    }

    public static void main(String [] args) {
        Solution sol = new Solution();
        sol.execute();
    }
}
