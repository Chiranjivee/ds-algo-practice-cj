class MaximumSumOfSelectedNumbersToMakeArrayEmpty {

    public int solve(int [] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            map.put(
                arr[i],
                map.containsKey(arr[i]) 
                    ? map.get(arr[i]) + 1 
                    : 1);
        }

        for (int i = 2; i <= max; i++) {
            map.put(i, Math.max(map.get(i - 1), map.get(i - 2) + i * map.get(i)));
        }

        return map.get(max);
    }
}
