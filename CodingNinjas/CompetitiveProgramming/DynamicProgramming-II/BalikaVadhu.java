import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class BalikaVadhu {
	public static void main(String[] args) {
		// Write your code here
      	Scanner sc = new Scanner(System.in);
      	int n = sc.nextInt();
      	while (n-- > 0) {
          	String s1 = sc.next();
          	String s2 = sc.next();
          	int k = sc.nextInt();
          	int [][][] dp = new int[s1.length() + 1][s2.length() + 1][k + 1];
          	int m = s1.length();
          	int n2 = s2.length();
            for (int i = 0; i <= s1.length(); i++) {
                for (int j = 0; j <= s2.length(); j++) {
                    Arrays.fill(dp[i][j], -1);
                }
            }
            
          	System.out.println(lcs(s1, s2, 0, 0, k, dp));
        }
	}
  
  	public static int lcs(String s1, String s2, int i, int j, int k, int [][][] dp){
      	int m = s1.length();
        int n = s2.length();
        
        if (k == 0) {
            return 0;
        }
        
        if (i == s1.length() || j == s2.length()) {
            return Integer.MIN_VALUE;
        }
        
        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            int optionOne = lcs(s1, s2, i + 1, j + 1, k - 1, dp);
            if (k - 1 != 0 && optionOne != 0) {
                optionOne += (int) s1.charAt(i);
            } else if (k - 1 == 0 && optionOne == 0) {
                optionOne += (int) s1.charAt(i);
            } else {
                optionOne = 0;
            }
            int optionTwo = lcs(s1, s2, i, j + 1, k, dp);
            int optionThree = lcs(s1, s2, i + 1, j, k, dp);
            return dp[i][j][k] = Math.max(optionOne, Math.max(optionTwo, optionThree));
        } else {
            int optionOne = lcs(s1, s2, i, j + 1, k, dp);
            int optionTwo = lcs(s1, s2, i + 1, j, k, dp);
            return dp[i][j][k] = Math.max(0, Math.max(optionOne, optionTwo));
        }
	}
}
