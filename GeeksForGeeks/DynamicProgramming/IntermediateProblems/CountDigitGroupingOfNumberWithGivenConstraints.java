class CountDigitGroupingOfNumberWithGivenConstraints {
    static int [][] dp = new int[1000][1000];
    public int countDigitGroup(char[] digits, int idx, int prevousSum) {
        if (idx == digits.length) {
            return 1;
        }

        if (dp[idx][prevousSum] != -1) {
            return dp[idx][prevousSum];
        }

        dp[idx][prevousSum] = 0;
        int res = 0;
        int sum = 0;

        for (int i = idx; i < digits.length; i++) {
            sum += (digits[i] - '0');

            if (sum >= prevousSum) {
                res += countDigitGroup(digits, i + 1, sum);
            }
        }

        return dp[idx][prevousSum] = res;
    }
}
