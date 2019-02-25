import java.util.Arrays;

public class Solution {

	public static int knapsack(int[] weight,int value[],int maxWeight) {
      	int n = weight.length;
				int [][] dp = new int[n + 1][maxWeight + 1];
      	for (int i = 0; i <= n; i++) {
          	Arrays.fill(dp[i], -1);
        }

    	knapsack(weight, value, maxWeight, n, dp);  	   
      	return dp[n][maxWeight];
	}
  
  	public static int knapsack(int [] weight, int value[], int maxWeight, int n, int [][] dp) {
      	if (n == 0 || maxWeight == 0) {
          	return 0;
        }
      
      	if (dp[n][maxWeight] != -1) return dp[n][maxWeight];
      
      	if (weight[n - 1] <= maxWeight) {
          	int optionOne = value[n - 1] + knapsack(weight, value, maxWeight - weight[n - 1], n - 1, dp);
          	int optionTwo = knapsack(weight, value, maxWeight, n - 1, dp);
          	dp[n][maxWeight] = Math.max(optionOne, optionTwo);
        } else {
          	dp[n][maxWeight] = knapsack(weight, value, maxWeight, n - 1, dp);
        }
      	return dp[n][maxWeight];
		}

		public static int knapsackIterative(int [] weight, int [] value, int maxWeight, int n) {
			int [] dp = new int[maxWeight + 1];
			int [] temp = new int[maxWeight + 1];
			for (int j = 0; j < n; j++) {
					for (int i = maxWeight; i >= weight[j]; i--) {
						dp[i] = Math.max(dp[i], value[j] + dp[i - weight[j]]);
					}
			}
		
			return dp[maxWeight];
		}
}
