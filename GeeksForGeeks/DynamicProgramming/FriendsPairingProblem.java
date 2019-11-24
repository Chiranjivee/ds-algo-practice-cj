/**
 * In this problem given a set of n friends
 * Each one can remain single or can be paired up with some other friend
 */
class FriendsPairingProblem {

    public int getWaysToPairFriend(int n) {

        if (n <= 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return n;
        }

        return 
            getWaysToPairFriend(n - 1) +                 // The person chooses to stay alone,
                (n - 1) * getWaysToPairFriend(n - 2);    // The person chooes to pair with any of the n - 1 people in the group, which could have n - 1 possibilites and the problem reduces to n - 2
    }

    public int getWaysToPairFriend(int n) {
        
        int [] dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            if (i <= 2) dp[i] = i;
            dp[i] = dp[i - 1] + (n - 1) * dp[n - 2];
        }

        return dp[n];
    }


    public static void main(String [] args) {
        System.out.pritnln(FriendsPairingProblem.solve());
    }
}
