import java.util.Arrays;

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[m + 1][n + 1][strs.length + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                Arrays.fill(dp[i][j], -1);
            }

        }
        return findMaxFormUtil(strs, 0, m, n, dp);
    }

    public int findMaxFormUtil(String[] strs, int idx, int m, int n, int[][][] dp) {
        if (idx == strs.length) {
            return 0;
        }

        if (dp[m][n][idx] != -1) {
            return dp[m][n][idx];
        }

        String curr = strs[idx];
        int zeros = 0;
        int ones = 0;
        for (int j = 0; j < curr.length(); j++) {
            if (curr.charAt(j) == '0') {
                zeros++;
            } else {
                ones++;
            }
        }

        int optionTwo = findMaxFormUtil(strs, idx + 1, m, n, dp);
        int optionOne = 0;
        if (m >= zeros && n >= ones) {
            optionOne = 1 + findMaxFormUtil(strs, idx + 1, m - zeros, n - ones, dp);
        }

        return dp[m][n][idx] = Math.max(optionOne, optionTwo);
    }
}
