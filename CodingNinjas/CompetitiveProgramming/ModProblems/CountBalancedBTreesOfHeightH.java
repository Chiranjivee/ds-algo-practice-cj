public class Solution {
    static int m = 1_000_000_000 + 7;

    public static int balancedTreesOfHeightH(int height) {
        if (height == 0 || height == 1) {
            return 1;
        }
        int x = balancedTreesOfHeightH(height - 1);
        int y = balancedTreesOfHeightH(height - 2);

        long ans1 = (long) x * x;
        int ans1Mod = (int) (ans1 % m);
        long ans2 = (long) x * y * 2;
        int ans2Mod = (int) (ans2 % m);
        return (ans1Mod + ans2Mod) % m;
    }
}
