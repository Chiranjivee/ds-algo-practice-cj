import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		// Write your code here
		Scanner sc = new Scanner(System.in);
      	int n = sc.nextInt();
      	
      	int [] assistant = new int[n];
      	int [] captain = new int[n];
      
      	for (int i = 0; i < n; i++) {
          	captain[i] = sc.nextInt();
          	assistant[i] = sc.nextInt();
        }
      
      	int [][] dp = new int[n + 1][n + 1];
		System.out.println(assistant[0] + f(assistant, captain, 1, n - 1, 1, dp));
	}
  
  	

  	public static int f(int [] assistant, int [] captain, int idx, int n, int x, int[][] dp) {
       	if (n <= 0|| x < 0 || x >= dp[0].length) {
         	return Integer.MAX_VALUE;
       	}
      
      	if(idx == captain.length - 1) {
        	if(x == 1) return captain[captain.length - 1];
        	else return Integer.MAX_VALUE;
    	}

      	if (dp[n][x] != 0) {
          	return dp[n][x];
        }
      
      	if (x == 0) {
          return dp[n][x] = assistant[idx] + f(assistant, captain, idx + 1, n - 1, x + 1, dp);
        } else if (x == n) {
          return dp[n][x] = captain[idx] + f(assistant, captain, idx + 1, n - 1, x - 1, dp);
        } else {
          	int optionOne = assistant[idx] + f(assistant, captain, idx + 1, n - 1, x + 1, dp);
          	int optionTwo = captain[idx] + f(assistant, captain, idx + 1, n - 1, x - 1, dp);
        	return dp[n][x] = Math.min(optionOne, optionTwo);
        }
    }
}
