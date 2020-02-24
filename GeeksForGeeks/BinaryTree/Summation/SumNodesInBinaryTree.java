class SumNoInBinaryTree {
    int sum = 0;
    public void sum(Node node) {
        if (node == null) return;
        sum += node.data;
        sum(node.left);
        sum(node.right);
    }
}
