class Node {
	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}

class BinaryTree {
	Node root;

	/* Returns true if the given tree can be folded */
	boolean IsFoldable(Node node) {
		if (node == null)
			return true;

		return IsFoldableUtil(node.left, node.right);
	}

	/* A utility function that checks if trees with roots as n1 and n2 
	 are mirror of each other */
	boolean IsFoldableUtil(Node n1, Node n2) {

		/* If both left and right subtrees are NULL, 
		 then return true */
		if (n1 == null && n2 == null)
			return true;

		/* If one of the trees is NULL and other is not, 
		 then return false */
		if (n1 == null || n2 == null)
			return false;

		/* Otherwise check if left and right subtrees are mirrors of 
		 their counterparts */
		return IsFoldableUtil(n1.left, n2.right) &&
			IsFoldableUtil(n1.right, n2.left);
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();

		/* The constructed binary tree is 
		     1 
		   /   \ 
		  2     3 
		   \    / 
		    4  5 
		*/
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.right.left = new Node(4);
		tree.root.left.right = new Node(5);

		if (tree.IsFoldable(tree.root))
			System.out.println("tree is foldable");
		else
			System.out.println("Tree is not foldable");
	}
}
