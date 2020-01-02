/**
 * 
 * You are given n days and for each day (di) you could either perform a high effort tasks (hi) 
 * or a low effort tasks (li) or no task with the constraint that you can choose a high-effort 
 * tasks only if you chose no task on the previous day. Write a program to find the maximum amount 
 * of tasks you can perform within these n days.
 */
class HighEffortVsLowEffortTaskProblem {
    public int getMaxTasks(int [] high, int [] low, int n) {
        if (n <= 0) {
            return 0;
        }

        int optionOne = high[n - 1] + getMaxTasks(high, low, n - 2);
        int optionTwo = low[n - 1] + getMaxTasks(high, low, n - 1);

        return Math.max(optionOne, optionTwo);
    }

    public int getMaxTasks(int [] high, int [] low, int n) {
        int [] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = Math.max(high[i - 1], low[i - 1] + dp[i - 1]);
                continue;    
            }

            dp[i] = Math.max(high[i - 1] + dp[i - 2], low[i - 1] + dp[i - 1]);
        }

        return dp[n];
    }
}
