/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        int res = 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int ans = guess(mid);
            if (ans == 0) {
                res = mid;
                break;
            } else if (ans == 1) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }
}
