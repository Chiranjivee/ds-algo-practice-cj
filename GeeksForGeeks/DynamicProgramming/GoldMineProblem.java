/**
 * This is problme is about collecting coing on a 2-D matrix starting from cell [0,0],
 * Possilbe direction to move are right, right-up, and right-down.
 * 
 * We need to find the maximum numbers of gold coins we can collect.
 * 
 * Note: Grid only contains positive coin denominations. And miner can start from any row.
 * 
 */
public class GoldMineProblem {

    public int collectMaxCoinsFromGoldMine(int [][] goldMine) {
        int rows = goldMine.length;
        int cols = goldMine[0].length;

        int [][] dp = new int[rows][cols];

        // start filling from the bottom right of the matrix
        for (int j = cols - 1; j >= 0; j--) {
            for (int i = rows - 1; i >= 0; i--) {

                int maxFromGoingRight = 
                    (j == cols - 1) // means you cannot go right.
                        ? 0 
                        : dp[i][j + 1];

                int maxFromGoingRightUp = 
                    (j == cols - 1 || i == 0) // means you cannot go right-up.
                        ? 0
                        : dp[i - 1][j + 1];
                        
                int maxFromGoingRightDown = 
                    (j == cols - 1 || i == rows - 1) // means you cannot go right-down.
                        ? 0
                        : dp[i + 1][j + 1];

                dp[i][j] = 
                    goldMine[i][j] 
                        + Math.max(
                            maxFromGoingRight, 
                            Math.max(maxFromGoingRightUp, maxFromGoingRightDown));
            }

            int max = dp[0][0];
            for (int i = 0; i < rows; i++) {
                max = Math.max(max, dp[i][0]);
            }

            return max;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		int testCasesCount = scanner.nextInt();
		while (testCasesCount-- > 0) {
		    int rows = scanner.nextInt();
		    int cols = scanner.nextInt();
		    
		    int [][] mat = new int[rows][cols];
		    for (int i = 0; i < rows; i++) {
		        for (int j = 0; j < cols; j++) {
		            mat[i][j] = scanner.nextInt();
		        }
		    }
		    
		    System.out.println(collectMaxCoinsFromGoldMine(mat));
		}
    }
}
