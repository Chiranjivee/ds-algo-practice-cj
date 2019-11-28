import java.util.Arrays;

class LargestDivisiblePairSubset {

    public int solveLargestDivisiblePairSubsetProblem(int [] input) {
        int [] dp = new int [input.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < input.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }

            max = Math.max(max, dp[i]);
        }
        
        return max;
    }

    public static void main(String[] args) {
        int [] input = new int [] {18, 1, 3, 6, 13, 17};
        Arrays.sort(input);

    }
}
