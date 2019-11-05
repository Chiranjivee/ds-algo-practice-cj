class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        if (barcodes == null || barcodes.length == 0)
            return new int[0];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : barcodes)
            map.put(i, map.getOrDefault(i, 0) + 1);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(
                (a, b) -> b.getValue() - a.getValue() == 0 ? a.getKey() - b.getKey() : b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            pq.offer(entry);
        int[] res = new int[barcodes.length];
        int i = 0;
        while (!pq.isEmpty()) {
            int k = 2;
            List<Map.Entry> tempList = new ArrayList<Map.Entry>();
            while (k > 0 && !pq.isEmpty()) {
                Map.Entry<Integer, Integer> head = pq.poll();
                head.setValue(head.getValue() - 1);
                res[i++] = head.getKey();
                tempList.add(head);
                k--;
            }
            for (Map.Entry<Integer, Integer> e : tempList) {
                if (e.getValue() > 0)
                    pq.add(e);
            }
            if (pq.isEmpty())
                break;
        }
        return res;
    }
}
