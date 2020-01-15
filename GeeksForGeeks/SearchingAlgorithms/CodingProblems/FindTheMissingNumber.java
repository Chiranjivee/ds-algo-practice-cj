class FindTheMissingNumber {

    public int missingNumber(int [] arr) {
        int n = arr.length;
        int sum = n + 1;
        for (int i = 0; i < n; i++) {
            sum += (i + 1);
            sum -= arr[i];
        }

        return sum;
    }
}
