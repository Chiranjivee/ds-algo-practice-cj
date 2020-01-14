class RandomNodeInTree {
    Random random = new Random();
    public Node getRandomNodeInTree(Tree root) {
        int size = getSizeOfTree(root);
        int randomNodeIdx = 1 + random.nextInt(size);
        return getNthNodeFromTree(randomNodeIdx);
    }
}
