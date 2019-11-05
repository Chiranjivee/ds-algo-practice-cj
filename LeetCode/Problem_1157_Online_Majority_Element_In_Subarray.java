class MajorityChecker {

    int[] arr;
    Map<Integer, List<Integer>> indexes;
    TreeMap<Integer, Set<Integer>> tm;
    public MajorityChecker(int[] arr) {
        this.arr = arr;
        indexes = new HashMap<>();
        tm = new TreeMap<>(Collections.reverseOrder());
        for(int i = 0; i < arr.length;i++) {
            if (!indexes.containsKey(arr[i])) {
                tm.computeIfAbsent(1, x -> new HashSet<>()).add(arr[i]);
            } else {
                int old = indexes.get(arr[i]).size();
                tm.get(old).remove(arr[i]);
                if (tm.get(old).size() == 0) {
                    tm.remove(old);
                }
                tm.computeIfAbsent(old+1, x -> new HashSet<>()).add(arr[i]);
            }
            indexes.computeIfAbsent(arr[i], x -> new ArrayList<>()).add(i);
        }
    }
    
    public int query(int left, int right, int threshold) {
        if (right - left + 1 < threshold) return -1;
        for (Map.Entry<Integer, Set<Integer>> entry: tm.entrySet()) {
            int key = entry.getKey();
            Set<Integer> value = entry.getValue();
            if (key < threshold) return -1;
            for(int v: value) {
                List<Integer> ps = indexes.get(v);
                int count = 0;
                for (int i = 0; i < ps.size() && ps.get(i) <= right; i++) {
                    if (ps.get(i) < left) continue;
                    count++;
                }
                if (count >= threshold) return v;
            }
        }
        return -1;
    }
}

/**
 * Your MajorityChecker object will be instantiated and called as such:
 * MajorityChecker obj = new MajorityChecker(arr);
 * int param_1 = obj.query(left,right,threshold);
 */