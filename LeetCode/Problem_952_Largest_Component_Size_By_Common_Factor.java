class Solution {
    int res;
    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, Integer> count = new HashMap<>();

    /**
     * inverted index - prime factor to list of numbers
     * 2->[4,16] 5->[35] 7->[35]
     */
    Map<Integer, Set<Integer>> index = new HashMap<>();

    public int largestComponentSize(int[] a) {

        // initialize UF + build inverted index
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], a[i]);
            count.put(a[i], 1);

            for (int p : getPrimeFactors(a[i])) {
                if (!index.containsKey(p)) index.put(p, new HashSet<>());
                index.get(p).add(a[i]);
            }
        }

        // for each inverted index - union all values
        for (Set<Integer> set : index.values()) {
            List<Integer> tmp = new ArrayList<>(set);
            for (Integer value : tmp) {
                union(tmp.get(0), value);
            }
        }

        return res;
    }

    // link https://www.geeksforgeeks.org/print-all-prime-factors-of-a-given-number/
    Set<Integer> getPrimeFactors(int x) {
        Set<Integer> set = new HashSet<>();

        while (x % 2 == 0) {
            set.add(2);
            x /= 2;
        }

        for (int i = 3; i <= Math.sqrt(x) + 1; i += 2) {
            while (x % i == 0) {
                set.add(i);
                x /= i;
            }
        }

        if (x > 2) set.add(x);
        return set;
    }


    int find(int x) {
        if (map.get(x) == x) return x;
        int par = find(map.get(x));
        map.put(x, par);
        return par;
    }

    void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return;

        // Union Find By Count
        int c = count.get(px) + count.get(py);
        if (count.get(px) <= count.get(py)) {
            map.put(px, py);
            count.put(py, c);
        } else {
            map.put(py, px);
            count.put(px, c);
        }
        res = Math.max(res, c);
    }
}
