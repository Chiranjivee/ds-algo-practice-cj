class PrintEqualSumSetsOfArray {
    public boolean canSetBePartitioned(int [] arr) {
        if (arr.length == 1) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        int targetSum = sum/2;
        boolean isPossible = isTargetSumPossible(arr, targetSum);

        List<Integer> set1 = new ArrayList<>();
        List<Integer> set2 = new ArrayList<>();

        int i = arr.length;
        while (i > 0 && targetSum > 0) {
            // element does not contribute
            if (dp[i - 1][targetSum]) {
                i--;
                set2.add(arr[i]);
            } else if (dp[i - 1][targetSum - arr[i - 1]]) {
                i--;
                set1.add(arr[i]);
                targetSum -= arr[i];
            }
        }

        printSet(set1);
        printSet(set2);
    }

    public boolean isTargetSumPossible(int [] arr, int targetSum, int idx) {
        boolean [][] dp = new int[arr.length + 1][targetSum + 1];
        for (int i = 0; i <= arr.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= targetSum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        return dp[arr.length][targetSum];
    }
}
