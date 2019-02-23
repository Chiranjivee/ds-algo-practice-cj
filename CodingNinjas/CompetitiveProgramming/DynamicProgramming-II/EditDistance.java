
public class EditDistance {
	public static int editDistance(String s1, String s2) {
      	int m = s1.length();
      	int n = s2.length();

      	int [][] dp = new int[m + 1][n + 1];
      	for (int i = 0; i < n + 1; i++) {
          	dp[0][i] = i;
        }

      	for (int i = 0; i < m + 1; i++) {
          	dp[i][0] = i;
        }

      	for (int i = 1; i < m + 1; i++) {
          	for (int j = 1; j < n + 1; j++) {
              	if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
                	dp[i][j] = 
                  		Math.min(dp[i - 1][j],
                  		Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;  
                } else {
                  	dp[i][j] = dp[i - 1][j - 1];
                }
              	
            }
        }
      	return dp[m][n];
	}
}
