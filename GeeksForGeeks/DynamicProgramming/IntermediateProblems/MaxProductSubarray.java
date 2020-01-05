class MaxProductSubarray {
    public int findMaxProductSubarray(int [] arr) {
        int n = arr.length;
        int [] dp = new int[n];

        int max = 1;
        int min = 1;

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                max = max * arr[i];
                min = Math.min(min, min * arr[i]);
            }

            if (arr[i] == 0) {
                max = 0;
                min = 1;
            }

            if (arr[i] < 0) {
                prevMax = max;
                max = min * arr[i];
                min = prevMax * arr[i];
            }

            res = Math.max(res, max);

            if (max <= 0) {
                max = 1;
            }
        }

        return res;
    }
}
