class TowerOfHonoi {
    public static void towerOfHanoi(int n, char A, char B, char C) {
        if (n == 1) {
            System.out.println(A + "->" + C);
            return;
        }

        towerOfHanoi(n - 1, A, C, B);
        System.out.println(A + "->" + C);
        towerOfHanoi(n - 1, B, A, C);
    }
    public static void main(String[] args) {
        towerOfHanoi(3, 'A', 'B', 'C');
    }
}