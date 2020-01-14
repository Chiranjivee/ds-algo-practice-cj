class RandomNodeFromList {
    public Node getRandomNode(Node head) {
        if (head == null) {
            return null;
        }

        Node result = head;
        Node current = head;
        for (int n = 2; current != null; n++) {
            int randomIdx = random.nextInt(n);
            if (randomIdx == 0) {
                result = current;
            }

            current = current.next;
        }
        return result;
    }
}
