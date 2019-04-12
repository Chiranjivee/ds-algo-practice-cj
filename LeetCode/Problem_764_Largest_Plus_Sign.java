class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] grid = new int[N][N];
        for (int i = 0; i < grid.length; i++)
            Arrays.fill(grid[i], 1);
        for (int i = 0; i < mines.length; i++)
            grid[mines[i][0]][mines[i][1]] = 0;

        Node[][] dp = new Node[N][N];
        Node[][] dp2 = new Node[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = new Node(grid[i][j]);
                    dp[i][j].halfDeg = Math.min(dp[i][j].top, dp[i][j].left);
                    continue;
                }

                if (grid[i][j] == 0) {
                    dp[i][j] = new Node(0);
                } else {
                    dp[i][j] = new Node(1);
                    dp[i][j].top += dp[i - 1][j].top;
                    dp[i][j].left += dp[i][j - 1].left;
                    dp[i][j].halfDeg = Math.min(dp[i][j].top, dp[i][j].left);
                }
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (i == grid.length - 1 || j == grid[0].length - 1) {
                    dp2[i][j] = new Node(grid[i][j]);
                    dp2[i][j].halfDeg = Math.min(dp2[i][j].bottom, dp2[i][j].right);
                    continue;
                }

                if (grid[i][j] == 0) {
                    dp2[i][j] = new Node(0);
                } else {
                    dp2[i][j] = new Node(1);
                    dp2[i][j].bottom += dp2[i + 1][j].bottom;
                    dp2[i][j].right += dp2[i][j + 1].right;
                    dp2[i][j].halfDeg = Math.min(dp2[i][j].bottom, dp2[i][j].right);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j].halfDeg = Math.min(dp[i][j].halfDeg, dp2[i][j].halfDeg);
                max = Math.max(max, dp[i][j].halfDeg);
            }
        }

        return max;
    }
}

class Node {
    int left;
    int right;
    int top;
    int bottom;
    int halfDeg;

    public Node(int i) {
        this.left = i;
        this.right = i;
        this.top = i;
        this.bottom = i;
    }
}
