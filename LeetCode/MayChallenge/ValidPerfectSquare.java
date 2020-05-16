class Solution {
    public boolean isPerfectSquare(int num) {
      if (num < 2) {
        return true;
      }
  
      long left = 2, right = num / 2, x, guessSquared;
      while (left <= right) {
        x = left + (right - left) / 2;
        guessSquared = x * x;
        if (guessSquared == num) {
          return true;
        }
        if (guessSquared > num) {
          right = x - 1;
        } else {
          left = x + 1;
        }
      }
      return false;
    }
}
