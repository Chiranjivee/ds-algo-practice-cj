class LongestPalindromicSubsequence {
    public int findLongestPalindromicSubsequence(char[] str) {
        int [][] dp = new int[str.length][str.length];

        // all characters are palindromes of size 1
        for (int i = 0; i < str.length; i++) {
            dp[i][i] = 1;
        }

        int rowIdx = 0;
        for (int colIdx = 1; colIdx < str.length; colIdx++) {
            // keep going diagonally down
            while (rowIdx < str.length) {
                if (str[rowIdx] == str[colIdx]) {
                    dp[rowIdx][colIdx] = 2 + dp[rowIdx + 1][colIdx - 1];
                } else {
                    dp[rowIdx][colIdx] = Math.max(dp[rowIdx + 1][colIdx], dp[rowIdx][colIdx - 1]);
                }
                rowIdx++;
            }

            rowIdx = 0;
        }

        return dp[0][str.length - 1];
    }
}