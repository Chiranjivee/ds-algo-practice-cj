class Node {
	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}

class BinaryTree {
	Node root1, root2;

	boolean identicalTrees(Node a, Node b) {
		/*1. both empty */
		if (a == null && b == null)
			return true;

		/* 2. both non-empty -> compare them */
		if (a != null && b != null)
			return (a.data == b.data &&
				identicalTrees(a.left, b.left) &&
				identicalTrees(a.right, b.right));

		/* 3. one empty, one not -> false */
		return false;
	}

	/* Driver program to test identicalTrees() function */
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();

		tree.root1 = new Node(1);
		tree.root1.left = new Node(2);
		tree.root1.right = new Node(3);
		tree.root1.left.left = new Node(4);
		tree.root1.left.right = new Node(5);

		tree.root2 = new Node(1);
		tree.root2.left = new Node(2);
		tree.root2.right = new Node(3);
		tree.root2.left.left = new Node(4);
		tree.root2.left.right = new Node(5);

		if (tree.identicalTrees(tree.root1, tree.root2))
			System.out.println("Both trees are identical");
		else
			System.out.println("Trees are not identical");

	}

	static boolean areIdentical(Node root1, Node root2) {
		// Return true if both trees are empty  
		if (root1 == null && root2 == null) return true;
	
		// Return false if one is empty and other is not  
		if (root1 == null || root2 == null) return false;
	
		// Create an empty queues for simultaneous traversals  
		Queue<Node> q1 = new LinkedList<Node> ();
		Queue<Node> q2 = new LinkedList<Node> ();
	
		// Enqueue Roots of trees in respective queues  
		q1.add(root1);
		q2.add(root2);
	
		while (!q1.isEmpty() && !q2.isEmpty()) {
			// Get front nodes and compare them  
			Node n1 = q1.peek();
			Node n2 = q2.peek();
	
			if (n1.data != n2.data)
				return false;
	
			// Remove front nodes from queues  
			q1.remove();
			q2.remove();
	
			/* Enqueue left children of both nodes */
			if (n1.left != null && n2.left != null) {
				q1.add(n1.left);
				q2.add(n2.left);
			}
	
			// If one left child is empty and other is not  
			else if (n1.left != null || n2.left != null)
				return false;
	
			// Right child code (Similar to left child code)  
			if (n1.right != null && n2.right != null) {
				q1.add(n1.right);
				q2.add(n2.right);
			} else if (n1.right != null || n2.right != null)
				return false;
		}
	
		return true;
	}
}
