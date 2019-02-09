import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Write your code here
		Scanner sc = new Scanner(System.in);
      	int t = sc.nextInt();
		while (t-- > 0) {
          	int m = sc.nextInt();
          	int n = sc.nextInt();
          	
          	int [][] mat = new int[m][n];
          	for (int i = 0; i < m; i++) {
              	for (int j = 0; j < n; j++) {
                  	mat[i][j] = sc.nextInt();
                }
            }

          	int [][] dp = new int[m][n];
          	solveIter(mat);
        }
	}
  	public static void solveIter(int [][] mat) {
      	int [][] dp = new int[mat.length][mat[0].length];
      	dp[mat.length - 1][mat[0].length - 1] = 1;
      	for (int r = mat.length - 1; r >= 0; r--) {
	      	for (int i = mat[0].length - 1; i >= 0; i--) {
              	if (i == mat[0].length - 1 && r == mat.length - 1)
                {
                  	continue;
                }
          		int optionOne = r == mat.length - 1 ? Integer.MAX_VALUE : dp[r + 1][i];
	          	int optionTwo = i == mat[0].length - 1 ? Integer.MAX_VALUE : dp[r][i + 1];
    	      	int ans = Math.min(optionOne, optionTwo);
          		int current = mat[r][i];
          		dp[r][i] = (current >= ans) ? 1 : ans - current;
        	}
        }
		
      	System.out.println(dp[0][0]);
    }
  
  	public static int solve(int[][] mat, int m, int n, int [][] dp) {
      	if (m > mat.length - 1  || n > mat[0].length - 1) {
          	return Integer.MAX_VALUE;
        }
      
      	if (m == mat.length - 1 && n == mat[0].length - 1) {
          	dp[m][n] = 1;
          	return 1;
        }
      
      	if (dp[m][n] != 0) return dp[m][n];
      
        int optionTwo = solve(mat, m, n + 1, dp);
      	int optionOne = solve(mat, m + 1, n, dp);

      	int ans = Math.min(optionOne, optionTwo);
      	int current = mat[m][n];

		dp[m][n] = (current >= ans) ? 1 : ans - current; 
      	return dp[m][n];
    }
}
