import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
      	int q = sc.nextInt();
      	while (q-- > 0) {
          	int k = sc.nextInt();
          	int n = sc.nextInt();
          	int [] arr = new int[n];
          	for (int i = 0; i < n; i++) {
              	arr[i] = sc.nextInt();
            }
          
          	int [][] dp = new int[k + 1][n + 1];
          
          	for (int i = 1; i <= k; i++) {
              	for (int j = 1; j <= n; j++) {
                  	int optionOne = dp[i][j - 1];
                  	int optionTwo = 0;                  
                  	for (int m = 1; m < j; m++) {
                      	optionTwo = Math.max(optionTwo, (arr[j - 1] - arr[m - 1]) + dp[i - 1][m]);
                    }
                  
                  	dp[i][j] = Math.max(optionOne, optionTwo);
                }
            }
          	System.out.println(dp[k][n]);
        }
	}
}
