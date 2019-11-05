class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int n = flights.length;
        int k = days[0].length;
        int[][] dp = new int[n][k + 1]; // add one extar column to the right
                
        // initialize the extra column
        for(int c = 0; c < n; c ++){
            dp[c][k] = 0;
        }
        
        // from week 'k - 1' to week 0
        for(int w = k - 1; w >= 0; w --){
            for(int c = 0; c < n; c ++){ // c -- city 
                int max = 0;
                for(int nc = 0; nc < n; nc ++){ // nc -- next city
                    if(flights[c][nc] == 1 || c == nc){
                        max = Math.max(days[nc][w] + dp[nc][w + 1], max);
                    }
                }
                dp[c][w] = max;
            }
        }
        
        return dp[0][0];
    }
}