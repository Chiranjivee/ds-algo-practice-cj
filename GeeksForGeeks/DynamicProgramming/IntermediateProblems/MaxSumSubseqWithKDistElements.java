class Solution {
    static int maxSum(int arr[], int N, int k) {
        int MS[] = new int[N];
  
        MS[N - 1] = arr[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            if (i + k + 1 >= N) {
                MS[i] = Math.max(arr[i], MS[i + 1]);
            } else {
                MS[i] = Math.max(arr[i] + MS[i + k + 1], MS[i + 1]);
            }
        }

        return MS[0];
    }
}
