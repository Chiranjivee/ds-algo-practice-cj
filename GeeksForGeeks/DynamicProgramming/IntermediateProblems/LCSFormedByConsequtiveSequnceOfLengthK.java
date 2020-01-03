class LCSFormedByConsequtiveSequenceOfLengthK {
    public int lcsWithKConsecutive(int k, String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int [][] dp = new int[n + 1][m + 1];
        int [][] cnt = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);


                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    cnt[i][j] = cnt[i - 1][j - 1] + 1;
                }


                if (cnt[i][j] >= k) {
                    for (int a = k; a <= cnt[i][j]; a++) {
                        lcs[i][j] = max(lcs[i][j], lcs[i - a][j - a]);
                    }
                }
            }
        }

        return lcs[n][m];
    }
}
