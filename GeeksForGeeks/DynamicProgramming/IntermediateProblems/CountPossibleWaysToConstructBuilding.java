class CountPossibleWaysToConstructBuilding {
    int countWays(int n) {
        if (n == 1) {
            return 4;
        }

        int countB = 1;
        int countS = 1;

        int prevCountB = 0;
        int prevCountS = 0;

        for (int i = 2; i <= n; i++) {

            prevCountB = countB;
            prevCountS = countS;

            countS = prevCountB + prevCountS;
            countB = prevCountS;
        }

        int result = countB + countS;
        return result * result;
    }
}
