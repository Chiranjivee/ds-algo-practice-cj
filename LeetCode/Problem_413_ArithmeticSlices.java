import java.util.Arrays;

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length == 0 || A.length == 1 || A.length == 2) {
            return 0;
        }
        
        boolean [][] dp = new boolean[A.length][A.length];
        int [][] st = new int[A.length][A.length];
        for (int i = 0; i < st.length; i++) 
        {
            Arrays.fill(st[i], -1);
        }
        return aSlice(A, 0, A.length - 1, dp, st);
    }
    
    public int aSlice(int [] A, int start, int end,boolean [][] dp, int[][] st) {
        
        if (st[start][end] != -1) {
            st[start][end] = 0;
            return st[start][end];
        }

        if (end - start == 2) {
            if (A[start + 1] - A[start] == A[end] - A[end - 1]) {
                dp[start][end] = true;
                st[start][end] = 1;
                return st[start][end];
            } else {
                dp[start][end]= false;
                st[start][end] = 0;
                return st[start][end];
            }
        }

        int optionOne = aSlice(A, start, end - 1, dp, st);
        int optionTwo = aSlice(A, start + 1, end, dp, st);

        if (dp[start][end - 1] && dp[start + 1][end]) {
            dp[start][end] = true;
            return st[start][end] = optionOne + optionTwo + 1;
        } else {
            dp[start][end] = false;
            return st[start][end] = optionOne + optionTwo;
        }
    }
}
