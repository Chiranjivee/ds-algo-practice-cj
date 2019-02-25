import java.util.Scanner;

public class SubsetSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
      	int n = sc.nextInt();
      	int [] arr=  new int[n];
      	for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
      
      	int sum = sc.nextInt();
      	sc.close();
      	System.out.println(knapsackIterative(arr, sum, n) ? "Yes" : "No");
	}
  
  	public static boolean knapsackIterative(int [] weight, int maxWeight, int n) {
      	boolean [] dp = new boolean[maxWeight + 1];
      	dp[0] = true;
      	for (int j = 0; j < n; j++) {
          	for (int i = maxWeight; i >= weight[j]; i--) {
	            dp[i] = dp[i] || dp[i - weight[j]];
            }
        } 
      	return dp[maxWeight];
    }
}
