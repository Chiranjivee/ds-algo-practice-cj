/**
 * 
 * There are N players which are playing a tournament. We need to find the maximum number of games the winner can play.
 * In this tournament, two players are allowed to play against each other only if the difference between games played 
 * by them is not more than one.
 * 
 * Sol: We can solve this problem by first computing minimum number of players required such that the winner will play x games. 
 * Once this is computed actual problem is just inverse of this. Now assume that dp[i] denotes minimum number of players required 
 * so that winner plays i games. We can write a recursive relation among dp values as, 
 * dp[i + 1] = dp[i] + dp[i – 1] because if runner up has played (i – 1) games and winner has played i games and all players against
 *  which they have played the match are disjoint, total games played by winner will be addition of those two sets of players. 
 * Above recursive relation can be written as dp[i] = dp[i – 1] + dp[i – 2] Which is same as the Fibonacci series relation,
 *  so our final answer will be the index of the maximal Fibonacci number which is less than or equal to given number of players 
 * in the input.
 * 
 */
class MaxGamesPlayedByWinner {
    public int getMaxGames(int n) {
        int [] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        int i = 2;
        do {
            dp[i] = dp[i - 1] + dp[i - 2];
        } while (dp[i++] <= n);

        return i - 2;
    }
}
