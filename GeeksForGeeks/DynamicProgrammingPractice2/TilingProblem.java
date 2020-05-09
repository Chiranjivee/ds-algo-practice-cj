class TilingProblem {
    public int tileBoard(int n) {

        if (n <= 0) return 0;

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        return tileBoard(n - 1) + tileBoard(n - 2);
    }
}
