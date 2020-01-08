class HosoyaTriangle {
    static int N = 5;

    static void printHosoya(int n) {
        int dp[][] = new int[N][N];

        // base case. 
        dp[0][0] = dp[1][0] = 1;
        dp[1][1] = 1;

        // For each row. 
        for (int i = 2; i < n; i++) {
            // for each column; 
            for (int j = 0; j < n; j++) {
                // recursive steps. 
                if (i > j)
                    dp[i][j] = dp[i - 1][j] + dp[i - 2][j];

                else
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 2][j - 2];
            }
        }

        // printing the solution 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++)
                System.out.print(dp[i][j] + " ");

            System.out.println("");
        }
    }
}
