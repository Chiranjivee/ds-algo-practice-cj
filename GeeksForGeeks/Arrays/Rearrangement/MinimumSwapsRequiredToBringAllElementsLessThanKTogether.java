/**
 * Given an array of n positive integers and a number k. 
 * Find the minimum number of swaps required to bring all 
 * the numbers less than or equal to k together.
 */
class MinimumSwaps {
    public int solve(int [] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < k) {
                count++;
            }
        }

        int bad = 0;
        for (int i = 0; i < count; i++) {
            if (arr[i] > k) {
                bad++;
            }
        }

        int ans = bad;
        for (int i = 0, j = count; j < arr.length; i++, j++) {
            if (arr[i] > k) {
                bad--;
            }

            if (arr[j] > k) {
                bad++;
            }
            ans = Math.min(ans, bad);
        }

        return ans;
    }
}
