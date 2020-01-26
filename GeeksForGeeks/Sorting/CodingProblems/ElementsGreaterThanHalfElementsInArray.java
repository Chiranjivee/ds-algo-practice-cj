class Solution {
    static void findLarger(int arr[], int n) {
        Arrays.sort(arr);
        for (int i = n - 1; i >= n / 2; i--)
            System.out.print(arr[i] + " ");
    }
}
