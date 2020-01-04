class CountNumberOfPathsWithAtMostKTurns {
    static int MAX = 100;
    static int [][][][] dp = new int[MAX][MAX][MAX][2];

    // count paths to reach i,j with k turns
    public int countPaths(int i, int j, int k) {

        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                for (int k = 0; k < MAX; k++) {
                    for (int l = 0; l < 2; l++) {
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }

        // d == 0 is moving along col, d == 1 is moving along row
        return countPathsWithDirection(i, j - 1, k, 0) + countPathsWithDirection(i - 1, j, k, 1);
    }

    public int countPathsWithDirection(int i, int j, int k, int d) {

        if (i < 0 || j < 0) {
            return 0;
        }

        if (i == 0 && j == 0) {
            return 1;
        }

        if (k == 0) {
            // moving along column
            if (d == 0 && i == 0) {
                return 1;
            }

            if (d == 1 && j == 0) {
                return 1;
            }

            return 0;
        }

        if (dp[i][j][k][d] != -1) {
            return dp[i][j][k][d];
        }

        if (d == 0) {
            return dp[i][j][k][d] = countPathsWithDirection(i, j - 1, k, 0) + countPathsWithDirection(i - 1, j, k - 1, 1);
        }

        return dp[i][j][k][d] = countPathsWithDirection(i - 1, j, k, 1) + countPathsWithDirection(i, j - 1, k - 1, 0);
    }
}
