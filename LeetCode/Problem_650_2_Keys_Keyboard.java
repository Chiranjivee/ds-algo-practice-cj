class Solution {
    public int minSteps(int n) {
        if (n == 1)
            return 0;
        return 1 + minSteps(n, n - 1, 1, true);
    }

    public int minSteps(int n, int remaining, int copied, boolean lastCopy) {
        if (remaining == 0) {
            return 0;
        }

        if (copied > remaining || remaining < 0) {
            return Integer.MAX_VALUE;
        }

        if (lastCopy) {
            int option1 = minSteps(n, remaining - copied, copied, false);
            if (option1 == Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            return 1 + option1;
        } else {
            int copy = minSteps(n, remaining, n - remaining, true);
            int paste = minSteps(n, remaining - copied, copied, false);

            int res = Math.min(copy, paste);
            if (res == Integer.MAX_VALUE)
                return res;
            return 1 + res;
        }
    }
}
