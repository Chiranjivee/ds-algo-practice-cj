class ConnectSiblings {
    public static void populate_sibling_pointers(BinaryTreeNode root) {
        if (root == null)
            return;

        BinaryTreeNode current = root;
        BinaryTreeNode last = root;

        while (current != null) {
            if (current.left != null) {
                last.next = current.left;
                last = current.left;
            }

            if (current.right != null) {
                last.next = current.right;
                last = current.right;
            }

            last.next = null;
            current = current.next;
        }
    }

    public static List<Integer> get_level_order_traversal_with_sibling(BinaryTreeNode root) {
        List<Integer> l = new ArrayList<Integer>();
        while (root != null) {
            l.add(root.data);
            // System.out.print(root.data + ", ");
            root = root.next;
        }
        return l;
    }

    public static void main(String[] args) {

        List<Integer> input = new ArrayList<Integer>();
        input.add(100);
        input.add(25);
        input.add(75);
        input.add(15);
        input.add(350);
        input.add(300);
        input.add(10);
        input.add(50);
        input.add(200);
        input.add(400);
        input.add(325);
        input.add(375);
        BinaryTreeNode root = BinaryTree.create_BST(input);

        BinaryTree.display_level_order(root);
        populate_sibling_pointers(root);

        System.out.println("Root -> next: " + root.next.data); // 25
        System.out.println("Root->right->left->next: " + root.right.left.next.data); // 400
        System.out.println("Root->right->right->next: " + root.right.right.next.data); // 10
        System.out.println("Root->right->right->left->next: " + root.right.right.left.next); // None

        List<Integer> l1 = BinaryTree.get_level_order(root);
        List<Integer> l2 = get_level_order_traversal_with_sibling(root);
        System.out.println("Connected? = " + Boolean.toString(ListUtil.is_equal(l1, l2)));
        System.out.println();
        ListUtil.print(l1);
    }
}
