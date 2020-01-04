class CountAllTripletsWhoseSumIsEqualToAPerfectCube {
    static int countTripletSum(int arr[], int n) {
        computeDpArray(arr, n);
        int ans = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = 1; k <= 24; k++) {
                    int cube = k * k * k;
                    int rem = cube - (arr[i] + arr[j]);

                    if (rem > 0) {
                        ans += dp[n - 1][rem] - dp[j][rem];
                    }
                }
            }
        }
        
        return ans;
    }
}
