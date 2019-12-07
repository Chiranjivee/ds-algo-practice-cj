class FindMissingNumber {
    /**
     * In a list of 1 to n - 1 numbers find the missing number
     */
    public int getMissingNumberFrom(int [] arr) {
        int n = arr.length + 1;
        int x = 0;
        for (int i = 1; i <= n; i++) {
            x ^= i;
        }
        
        int y = 0;
        for (int i = 0; i < arr.length; i++) {
            y ^= arr[i];
        }

        return x ^ y;
    }
}