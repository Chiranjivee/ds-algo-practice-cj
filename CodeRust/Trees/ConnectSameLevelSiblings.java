class ConnectSameLevelSiblings {
    private static BinaryTreeNode connect_next_level(BinaryTreeNode head) {
        BinaryTreeNode current = head;
        BinaryTreeNode next_level_head = null;
        BinaryTreeNode prev = null;

        while (current != null) {
            if (current.left != null && current.right != null) {
                if (next_level_head == null) {
                    next_level_head = current.left;
                }

                current.left.next = current.right;

                if (prev != null) {
                    prev.next = current.left;
                }

                prev = current.right;
            } else if (current.left != null) {
                if (next_level_head == null) {
                    next_level_head = current.left;
                }

                if (prev != null) {
                    prev.next = current.left;
                }

                prev = current.left;
            } else if (current.right != null) {
                if (next_level_head == null) {
                    next_level_head = current.right;
                }

                if (prev != null) {
                    prev.next = current.right;
                }

                prev = current.right;
            }

            current = current.next;
        }

        if (prev != null) {
            prev.next = null;
        }

        return next_level_head;
    }

    public static void populate_sibling_pointers(BinaryTreeNode root) {

        if (root == null) {
            return;
        }

        root.next = null;

        do {
            root = connect_next_level(root);
        } while (root != null);
    }

    static List<Integer> get_level_order_using_next(BinaryTreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        while (root != null) {
            BinaryTreeNode head = root;
            BinaryTreeNode next_head = null;
            while (head != null) {
                output.add(head.data);

                if (next_head == null) {
                    next_head = head.left != null ? head.left : head.right;
                }

                head = head.next;
            }
            root = next_head;
        }
        return output;
    }

    public static void main(String[] args) {
        List<Integer> v = new ArrayList<Integer>();
        v.add(100);
        v.add(25);
        v.add(75);
        v.add(15);
        v.add(350);
        v.add(300);
        v.add(10);
        v.add(50);
        v.add(200);
        v.add(400);
        v.add(325);
        v.add(375);

        BinaryTreeNode head = BinaryTree.create_BST(v);

        List<Integer> v1 = BinaryTree.get_level_order(head);

        populate_sibling_pointers(head);

        List<Integer> result = get_level_order_using_next(head);

        System.out.println("Result Tree: " + result);
        System.out.println("100 -> next: " + head.next); // null
        System.out.println("25 -> next: " + head.left.next.data); // 350
        System.out.println("75 -> next: " + head.left.right.next.data); // 300
        System.out.println("300 -> next: " + head.right.right.next); // null

        System.out.println("Siblings Connected : " + ListUtil.is_equal(v1, result));
    }
}
