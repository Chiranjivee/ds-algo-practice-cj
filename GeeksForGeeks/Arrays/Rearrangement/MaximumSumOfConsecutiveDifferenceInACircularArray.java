import java.util.Arrays;

class MaximumSumOfConsecutiveDifferenceInACircularArray {
    public int maxSum(int [] arr) {
        // rearrangement is allowed
        Arrays.sort(arr);

        int sum = 0;
        for (int i = 0; i < n / 2; i++) {
            sum -= 2 * arr[i];
            sum += 2 * arr[n - 1 - i];
        }
        return sum;
    }
}
