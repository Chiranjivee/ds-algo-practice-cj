
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class StringMaker {
    static int MOD = 1_000_000_000 + 7;

    public int solve(String a, String b, String c) {
        int[][][] dp = new int[a.length() + 1][b.length() + 1][c.length() + 1];
        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solveUtil(a, b, c, -1, -1, 0, dp);
    }

    public int solveUtil(String a, String b, String c, int aIdx, int bIdx, int cIdx, int[][][] dp) {
        if (cIdx == c.length())
            return 1;

        if (aIdx != -1 && bIdx != -1) {
            if (dp[aIdx][bIdx][cIdx] != -1)
                return dp[aIdx][bIdx][cIdx];
        }

        char currentChar = c.charAt(cIdx);
        List<Integer> l1 = new ArrayList<>();
        for (int i = aIdx + 1; i < a.length(); i++)
            if (a.charAt(i) == currentChar) l1.add(i);

        int option1 = 0;
        for (Integer i : l1) {
            option1 += solveUtil(a, b, c, i, bIdx, cIdx + 1, dp);
            option1 %= MOD;
        }

        List<Integer> l2 = new ArrayList<>();
        for (int i = bIdx + 1; i < b.length(); i++)
            if (b.charAt(i) == currentChar) l2.add(i);

        int option2 = 0;
        for (Integer i : l2) {
            option2 += solveUtil(a, b, c, aIdx, i, cIdx + 1, dp);
            option2 %= MOD;
        }

        int result = ((option1 % MOD) + (option2 % MOD)) % MOD;
        if (aIdx != -1 && bIdx != -1) return dp[aIdx][bIdx][cIdx] = result;
        return result;
    }
}
