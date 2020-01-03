class CountAllIncreasingSubsequence {
    public int countSub(int [] arr, int n) {
        int [] count = new int[10];

        for (int i = 0; i < n; i++) {
            for (int j = arr[i] - 1; j >= 0; j--) {
                count[arr[i]] += count[j];
            }

            count[arr[i]]++;
        }

        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += count[i];
        }

        return result;
    }
}
