import java.util.Scanner;

public class MiserMan {
	public static void main(String[] args) {
      	Scanner sc = new Scanner(System.in);
      	int m = sc.nextInt();
      	int n = sc.nextInt();
      
      	int [][] mat = new int[m][n];
      	
      	for (int i = 0; i < m; i++) {
          	for (int j = 0; j < n; j++) {
              	mat[i][j] = sc.nextInt();
            }
        }
        sc.close();
      
      	int [][] dp = new int[m][n];
      	for (int i = 0; i < n; i++) {
          	dp[m - 1][i] = mat[m - 1][i];
        }
      
      	for (int i = m - 2; i >= 0; i--) {
          	for (int j = n - 1; j >= 0; j--) {
              	if (j == n - 1) {
                  	dp[i][j] = mat[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j - 1]);
                } else if (j == 0) {
                  	dp[i][j] = mat[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
                } else {
                  	dp[i][j] = mat[i][j] + Math.min(dp[i + 1][j], Math.min(dp[i + 1][j + 1], dp[i + 1][j - 1]));
                }
            }
        }
                                                    
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
          	min = Math.min(min, dp[0][i]);
        }
		System.out.println(min);
	}
}
