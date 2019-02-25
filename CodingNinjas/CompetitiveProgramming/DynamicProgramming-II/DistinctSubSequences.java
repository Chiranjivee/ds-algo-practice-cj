import java.util.Scanner;
import java.util.Arrays;
public class DistinctSubSequences {
	static int MOD = 1_000_000_007;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
      	int n = sc.nextInt();
      	while (n-- > 0) {
          	String s = sc.next();
          	System.out.println(solve(s));
        }
	}
  
  	public static long solve(String s) {
      	long [] dp = new long[s.length() + 1];
      	dp[0] = 1;

        int[] last = new int[256]; 
        Arrays.fill(last, -1); 
      	for (int i = 1; i <= s.length(); i++) {
          	dp[i] = dp[i - 1] << 1;
          	if (dp[i] >= MOD) dp[i] -= MOD;
          	if (last[(int) s.charAt(i - 1)] != -1) {
              	dp[i] = dp[i] - dp[last[(int) s.charAt(i - 1)]];
              	if (dp[i] < 0) dp[i] += MOD; 
            }
          	last[(int) s.charAt(i - 1)] = i - 1;
        } 
      	return dp[s.length()];
    }
}
