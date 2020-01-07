class FindMinSumWithEveryThreeConsecutiveElements {
    int findMinSum(int arr[], int n) {
        int sum[] = new int[n];

        sum[0] = arr[0];
        sum[1] = arr[1];
        sum[2] = arr[2];
    
        // Iterate through all other elements 
        for (int i = 3; i<n; i++)
            sum[i] = arr[i] + minimum(sum[i - 3], sum[i - 2], sum[i - 1]);
    
        return minimum(sum[n - 1], sum[n - 2], sum[n - 3]);
    }
}
