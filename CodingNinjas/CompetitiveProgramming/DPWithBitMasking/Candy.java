import java.util.Arrays;
public class solution {
	
	long solve(int[][] like,int N){
		
		//Write your code here.
        long [] dp = new long[(int) Math.pow(2, N) - 1];
        Arrays.fill(dp, -1);
        return solveUtil(like, N, 0, 0, dp);
	}
    
    long solveUtil(int[][] like, int N, int st, int mask, long[] dp) {        
        if (st == N) {
            return 1;
        }
        
        if (dp[mask] != -1) {
            return dp[mask];
        }

        int res = 0;
        for (int c = 0; c < N; c++) {
            if ((mask & (1 << c)) == 0 && like[st][c] == 1) {
                long ans = solveUtil(like, N, st + 1, mask | (1 << c), dp);
                res += ans;
            }
        }
        return dp[mask] = res;
    }
}
