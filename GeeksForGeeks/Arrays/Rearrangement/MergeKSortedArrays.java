class MergeKSortedArrays {

    public void mergeSortedArrays(int [][] arr) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer, Node> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            if (arr[i].length != 0) {
                map.put(i, new Node(0, arr[i].length));
                pq.offer(arr[i][0]);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (pq.size() != 0) {
            result.add(pq.poll());

            List<Integer> obsoleteIdxs = new ArrayList<>();
            for (Map.Entry<Integer, Node> entry: map.entrySet()) {
                Node node = entry.getValue();
                if (i + 1 < node.getSize() - 1) {
                    pq.offer(arr[entry.getKey()][i + 1]);
                    node.setIndex(i + 1);
                } else {
                    obsoleteIdxs.add(entry.getKey());
                }
            }

            for (Integer e : obsoleteIdxs) {
                map.remove(e);
            }
        }
    }
}

class Node {
    int index;
    int size;
}
