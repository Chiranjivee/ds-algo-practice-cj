public class Solution {
    static int m = 1_000_000_000 + 7;

    public static int balancedTreesOfHeightH(int height) {
        if (height == 0 || height == 1) {
            return 1;
        }

        int x = balancedTreesOfHeightH(height - 1);
        int y = balancedTreesOfHeightH(height - 2);
        int xModM = x % m;
        int yModM = y % m;
        return
        (
            ((xModM * xModM) % m)
            +
            (((2 * xModM % m) * yModM) % m)
        ) % m;
    }
}
