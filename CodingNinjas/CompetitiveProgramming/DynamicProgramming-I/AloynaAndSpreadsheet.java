import java.util.Scanner;

public class AloynaAndSpreadsheet {
	
	public static void main(String[] args) {
		// Write your code here
		Scanner sc = new Scanner(System.in);
      	int m = sc.nextInt();
      	int n = sc.nextInt();
      
      	int [][] mat = new int[m][n];
      	for (int i = 0; i < m; i++) {
          	for (int j = 0; j < n; j++) {
              	mat[i][j] = sc.nextInt();
            }
        }
      
      	int [][] dp = new int[m][n];
      
      	for (int i = 0; i < m; i++) {
          	for (int j = 0; j < n; j++) {
              	if (i == 0) {
                  	dp[i][j] = 0;
                  	continue;
                }
              	if (mat[i][j] < mat[i - 1][j]) {
                  	dp[i][j] = i;
                } else {
                  	dp[i][j] = dp[i - 1][j];
                }
            }
        }
      
      
      	int k = sc.nextInt();
      	for (int i = 0; i < k; i++) {
          	int l = sc.nextInt();
          	int r = sc.nextInt();
          	l--; r--;
          	String ans = "No";
          	for (int j = 0; j < n; j++) {
              	if (dp[r][j] <= l) {
                  	ans = "Yes";
                  	break;
                }
            }
          	System.out.println(ans);
        }
	}
}
