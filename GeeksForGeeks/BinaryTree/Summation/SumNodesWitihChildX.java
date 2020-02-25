class SumNodesWithChildX {
    int sum = 0;
    public void sum(Node node, int x) {
        if (node == null) return;
        if (hasChildWithX(node, x)) sum += node.data;
        sum(node.left, x);
        sum(node.right, x);
    }

    public boolean hasChildWithX(Node node, int x) {
        if (node.left == null && node.right == null) {
            return false;
        }

        if (node.left != null && node.left == x) {
            return true;
        }

        if (node.right != null && node.right == x) {
            return true;
        }

        return false;
    }
}
