class MinimumJumpToReachLastBuildingInMatrix {
    static int minJump(int height[][], int x, int y) {
        // if we visited it before 
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        if (x == R - 1 && y == C - 1) {
            return (dp[x][y] = 0);
        }
  
        // Find minimum jumps if we go through diagonal 
        int diag = Integer.MAX_VALUE;
        if (isSafe(x + 1, y + 1)) {
            diag = minJump(height, x + 1, y + 1) + Math.abs(height[x][y] - height[x + 1][y + 1]); 
        }

        // Find minimum jumps if we go through down 
        int down = Integer.MAX_VALUE;
        if (isSafe(x + 1, y)) {
            down = minJump(height, x + 1, y) + Math.abs(height[x][y] - height[x + 1][y]); 
        }

        // Find minimum jumps if we go through right 
        int right = Integer.MAX_VALUE;
        if (isSafe(x, y + 1)) {
            right = minJump(height, x, y + 1) + Math.abs(height[x][y] - height[x][y + 1]);
        }

        // return minimum jump
        dp[x][y] = Math.min(Math.min(down, right), diag);
        return dp[x][y];
    }
}
