import java.util.Arrays;
/**
 * 
 * Golomb sequence: A sequence where nth element says how many times n appears in the sequence.
 * Recursive Definition:
 *  G(1) = 1;
 *  G(n + 1) = G(n + 1 - G(G(n))) + 1;
 */
class GolombSequence {

    public void printNElementsOfGolombSequence(int n) {

        int [] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - dp[dp[i - 1]]] + 1;
        }

        System.out.println(Arrays.toString(dp));
    }

    public static void main(String[] args) {

    }
}
