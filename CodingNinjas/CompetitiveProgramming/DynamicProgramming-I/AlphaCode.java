import java.util.Scanner;
import java.util.Arrays;

public class AlphaCode {
  static int mod = 1_000_000_000 + 7;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      String input = sc.nextLine();
      if (input.equals("0")) {
        break;
      }
      int [] dp = new int[input.length() + 1];
      Arrays.fill(dp, -1);
      System.out.println(solveBottomUp(input));
    }
  }
  
  public static long solveBottomUp(String input) {
    long [] dp = new long[input.length() + 1];
    dp[0] = 1;
	dp[1] = 1;
    for (int i = 2; i <= input.length(); i++) {
      	dp[i] = dp[i - 1];
      	if (input.charAt(i - 1) == '0') {
          	dp[i] = 0;
        }

      	int digit = 
          Character.getNumericValue(input.charAt(i - 2)) * 10 +
          			Character.getNumericValue(input.charAt(i - 1));
      	if (digit >= 10 && digit <= 26) {
          	dp[i] = (dp[i] % mod + dp[i - 2] % mod) % mod;
        }
    }
  	return dp[input.length()] % mod;
  }

  public static int solve(String input, int index, int [] dp) { 
   	if (index == input.length()) {
      	if (dp[index] == -1) {
            dp[index] = 1;
        }
      	else if (dp[index] >= 0) {
          	dp[index] += 1;
        }
        return 1;
   	}

   	int optionOne = Character.getNumericValue(input.charAt(index));
    int result = 0;
    if (optionOne == 0) {
		dp[index] = 0;
      	return 0;
    } else {
      	if (dp[index + 1] != -1) {
            System.out.println("From memo");
        	result += dp[index + 1];          
        } else {
        	result += solve(input, index + 1, dp);  
        }
    }
    
    if (index + 1 < input.length()) {
      int optionTwo = 
        Character.getNumericValue(input.charAt(index)) * 10 + 
        Character.getNumericValue(input.charAt(index + 1));
      
    	if (optionTwo >= 10 && optionTwo <= 26) {
          if (dp[index + 2] != -1) {
            System.out.println("From memo");
        	result += dp[index + 2];          
	      } else {
    	    result += solve(input, index + 2, dp);
          }
    	}
    }
    
	return result % mod;
  }
}