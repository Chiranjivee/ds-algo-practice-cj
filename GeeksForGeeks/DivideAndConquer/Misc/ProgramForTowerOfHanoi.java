class ProgramForTowerOfHanoi {
    public void printTowerOfHanoiSol(int n, char A, char B, char C) {
        if (n == 1) {
            System.out.println(A + "->" + C);
            return;
        }

        printTowerOfHanoiSol(n - 1, A, C, B);
        System.out.println(A + "->" + C);
        printTowerOfHanoiSol(n - 1, B, A, C);
    }
}
