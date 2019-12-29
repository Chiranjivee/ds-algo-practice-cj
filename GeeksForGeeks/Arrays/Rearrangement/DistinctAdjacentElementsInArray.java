class DistinctAdjacentElementsInArray {
    public void solve(int [] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            max = Math.max(max, value);
        }

        if (max < (n + 1) / 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
