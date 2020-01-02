class LongestPalindromicSubstring {
    public int getLongestPalindromicSubstringLength(String str) {
        boolean [][] dp = new int[str.length][str.length];

        // all characters are palindromes of size 1
        for (int i = 0; i < str.length; i++) {
            dp[i][i] = true;
        }

        int rowIdx = 0;
        for (int colIdx = 1; colIdx < str.length; colIdx++) {
            // keep going diagonally down
            while (rowIdx < str.length - 1) {
                if (colIdx - rowIdx == 1 && str[rowIdx] == str[colIdx]) {
                    dp[rowIdx][colIdx] = true;
                    continue;
                }

                if (str[rowIdx] == str[colIdx] && dp[rowIdx + 1][colIdx - 1]) {
                    dp[rowIdx][colIdx] = true;
                } else {
                    dp[rowIdx][colIdx] = false;
                }

                rowIdx++;
            }

            rowIdx = 0;
        }

        return dp[0][str.length - 1];
    }
}
