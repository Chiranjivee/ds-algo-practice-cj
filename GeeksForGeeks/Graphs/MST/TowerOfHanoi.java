class TowerOfHanoi {
    public void solve(int n) {
        solveUtil(n, 's', 'e', 'd');
    }

    public void solveUtil(int n, char s, char e, char d) {
        if (n == 0) {
            return;
        }

        solveUtil(n - 1, s, d, e);
        System.out.println("From " + s + " to " + d);
        solveUtil(n - 1, e, s, d);
    }

    public static void main(String[] args) {
        TowerOfHanoi t = new TowerOfHanoi();
        t.solve(4);
    }
}