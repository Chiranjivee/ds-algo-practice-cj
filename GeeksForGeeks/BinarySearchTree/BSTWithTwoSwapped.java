class BSTWithTwoSwapped {
    Node first;
    Node middle;
    Node last;
    Node prev;

    public void inorder(Node root) {
        if (root == null) {
            return;
        } 

        inorder(root.left);

        if (prev != null && root.data < prev) {
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }

        prev = root;
        inorder(root.right);
    }

    public Node eval(Node root) {
        first = null;
        middle = null;
        last = null;
        prev = null;
        inorder(root);

        if (first != null && last != null) {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        } else {
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }

        return root;
    }
}
