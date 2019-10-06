import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] costs = new int[] { 2, 7, 15 };
        int[] days = new int[] { 4, 6, 7, 8, 20 };
        Solution sol = new Solution();
        System.out.println(sol.mincostTickets(days, costs));
    }

    public int mincostTickets(int[] days, int[] costs) {
        if (days.length == 0) {
            return 0;
        }

        int[] dp = new int[days.length];
        Arrays.fill(dp, -1);
        System.out.println(mincostTicketBottomUp(days, costs));
        return mincostTicketsUtil(days, 0, costs, dp);
    }

    public int mincostTicketBottomUp(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        for (int i = days.length - 1; i >= 0; i--) {
            int weekDayIdx = getNextDayIdx(days, i, 6);
            int monthDayIdx = getNextDayIdx(days, i, 29);

            int optionOne = costs[0] + ((i == days.length - 1) ? 0 : dp[i + 1]);
            int optionTwo = Integer.MAX_VALUE;
            int optionThree = Integer.MAX_VALUE;

            if (weekDayIdx != 0)
                optionTwo = costs[1] + ((weekDayIdx < days.length) ? dp[weekDayIdx] : 0);
            if (monthDayIdx != 0)
                optionThree = costs[2] + ((monthDayIdx < days.length) ? dp[monthDayIdx] : 0);
            dp[i] = Math.min(optionOne, Math.min(optionTwo, optionThree));
        }

        return dp[0];
    }

    public int mincostTicketsUtil(int[] days, int dayIdx, int[] costs, int[] dp) {
        if (dayIdx == days.length) {
            return 0;
        }

        if (dp[dayIdx] != -1)
            return dp[dayIdx];

        int optionOne = costs[0] + mincostTicketsUtil(days, dayIdx + 1, costs, dp);
        int weekDayIdx = getNextDayIdx(days, dayIdx, 6);
        int monthDayIdx = getNextDayIdx(days, dayIdx, 29);

        int optionTwo = Integer.MAX_VALUE;
        int optionThree = Integer.MAX_VALUE;

        if (weekDayIdx != 0)
            optionTwo = costs[1] + mincostTicketsUtil(days, weekDayIdx, costs, dp);

        if (monthDayIdx != 0)
            optionThree = costs[2] + mincostTicketsUtil(days, monthDayIdx, costs, dp);

        int res = Math.min(optionOne, Math.min(optionTwo, optionThree));
        dp[dayIdx] = res;
        return res;
    }

    public int getNextDayIdx(int[] days, int dayIdx, int offset) {
        int currentDay = days[dayIdx];
        // find the entry just greater than valid day
        int validDay = currentDay + offset;
        if (validDay >= days[days.length - 1]) {
            return days.length;
        }

        int nextDayIdx = 0;
        for (int i = dayIdx; i < days.length; i++) {
            if (days[i] > validDay) {
                nextDayIdx = i;
                break;
            }
        }

        return nextDayIdx;
    }
}
