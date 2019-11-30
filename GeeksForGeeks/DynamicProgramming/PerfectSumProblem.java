/**
 * 
 * Given an array of numbers, 
 * Print the sub-set whose sum equal to target
 */
class PerfectSumProblem {

    public void display(ArrayList<Integer> list) {
        System.out.println(list);
    }

    public void printSubsetsRecursively(int [] arr, boolean[][] dp, int i, int j, ArrayList<Integer> list) {

        if (i < 0 || j < 0) {
            return;
        }

        if (j == 0) {
            display(list);
            list.clear();
            return;
        }

        if (dp[i - 1][j]) {
            printSubsetsRecursively(arr, dp, i - 1, j, list);
        }

        if (j > arr[i - 1] && dp[i - 1][j - arr[i - 1]]) {
            list.add(arr[i - 1]);
            printSubsetsRecursively(arr, dp, i - 1, j - arr[i - 1], list);
        }

    }

    public void findSubsetsWithPerfectSum(int [] arr, int target) {

        boolean [][] dp = new boolean[arr.length + 1][target + 1];
        for (int i = 0; i < arr.length + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < target + 1; i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 1; j <= target; j++) {
                if (j < arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        if (dp[arr.length][target] == false) {
            System.out.println("No subset found for target: " + target);
            return;
        }

        ArrayList<Integer> list = new ArrayList<>();
        printSubsetsRecursively(arr,  target, list);

    }

    public static void main(String[] args) {

    }
}