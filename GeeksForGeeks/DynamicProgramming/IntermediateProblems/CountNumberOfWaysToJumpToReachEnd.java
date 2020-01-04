class CountNumberOfWaysToJumpToReachEnd {
    public int findWays(int [] arr) {
        int n = arr.length;
        int [] count = new int[n];
        count[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= n - i - 1) {
                count[i]++;
            }

            for (int j = i + 1; j < n - 1 && j < arr[i] + i; j++) {
                if (count[j] != -1) {
                    count[i] += count[j];
                }
            }

            if (count[i] == 0) {
                count[i] = -1;
            }
        }
    }

    System.out.println(Arrays.toString(count));
}
