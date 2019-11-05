class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int satisfy = 0, max = 0;
        for (int i = 0, win = 0; i < grumpy.length; ++i) {
            if (grumpy[i] == 0) { satisfy += customers[i]; }
            else { win += customers[i]; }
            if (i >= X) {
                win -= grumpy[i - X] * customers[i - X];
            }
            max = Math.max(win, max);
        }
        return satisfy + max;
    }
}
