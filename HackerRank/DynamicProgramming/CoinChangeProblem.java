import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the getWays function below.
	static long getWays(long value, long denominations[]) {
		int rows = denominations.length + 1;
		int cols = (int) value + 1;
		long[][] dp = new long[rows][cols];
		for (int i = 0; i<rows; i++) {
			for (int j = 0; j<cols; j++) {
				if (i == 0)
					continue;
				if (j == 0) {
					dp[i][j] = 1;
					continue;
				}
				if (j - denominations[i - 1] >= 0)
					dp[i][j] = dp[i][j - (int) denominations[i - 1]] + dp[i - 1][j];
				else
					dp[i][j] = dp[i - 1][j];
			}
		}
		return dp[rows - 1][cols - 1];
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nm = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nm[0]);

		int m = Integer.parseInt(nm[1]);

		long[] c = new long[m];

		String[] cItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i<m; i++) {
			long cItem = Long.parseLong(cItems[i]);
			c[i] = cItem;
		}

		// Print the number of ways of making change for 'n' units using coins having
		// the values given by 'c'

		long ways = getWays(n, c);
		// System.out.println(ways);
		bufferedWriter.write(Long.toString(ways));
		bufferedWriter.close();

		scanner.close();
	}
}