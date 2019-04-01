import java.util.Scanner;
import java.util.Arrays;

public class MehtaAndBankRobbery {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();

        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            items[i] = new Item();
            items[i].profit = sc.nextInt();
            items[i].weight = sc.nextInt();
        }

        Arrays.sort(items, (i1, i2) -> i1.profit - i2.profit);

        long [][][] dp = new long[2][n + 1][w + 1];
        long primes[] = new long[] {1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
        
        // Base case
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                // don't include the current element
                dp[0][i][j] = dp[0][i - 1][j];
                if (j >= items[i - 1].weight) {
                    dp[0][i][j] = Math.max(dp[0][i][j], dp[0][i - 1][j - items[i - 1].weight] + items[i - 1].profit);
                }
            }
        }
        
        for (int prime = 1; prime <= 10; prime++) {
            int p = prime % 2;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= w; j++) {
                    dp[p][i][j] = dp[p][i - 1][j];
                    if (j >= items[i - 1].weight) {
                        dp[p][i][j] = 
                            Math.max(dp[p][i][j], 
                                Math.max(
                                    dp[p][i - 1][j - items[i - 1].weight] + items[i - 1].profit, 
                                    dp[p ^ 1][i - 1][j - items[i - 1].weight] + items[i - 1].profit * primes[prime]));
                    }
                }
            }
        }

        System.out.println(dp[0][n][w]);
	}
}


class Item {
    int weight;
    int profit;
}