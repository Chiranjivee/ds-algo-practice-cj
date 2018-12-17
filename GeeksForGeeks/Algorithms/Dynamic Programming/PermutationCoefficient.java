class PermutationCoefficient {

    /**
     * recursive way
     * @param n
     * @param k
     * @return
     */
    static int permutation(int n, int k) {
        if (n == 0 && k == 0) return 1;
        if (n == 0 && k != 0) return 0;
        if (k == 0) return 1;
        return permutation(n - 1, k) + k * permutation(n - 1, k - 1);
    }


    /**
     * dynamic programming way
     * @param n
     * @param k
     * @return
     */
    static int permutationMemoised(int n, int k) {
        int [][] memo = new int[n + 2][k + 2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (j == 0) {
                    memo[i][j] = 1;    
                } else {
                    memo[i][j] = j * memo[i - 1][j - 1] + memo[i - 1][j];
                }
                memo[i][j + 1] = 0;   
            }
        }
        
        return memo[n][k];
    }

    static void printMemo(int [][] memo) {
        System.out.println("Memo is: ");
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                System.out.print(memo[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println(permutation(10, 2));
        System.out.println(permutationMemoised(10, 2));
    }
}