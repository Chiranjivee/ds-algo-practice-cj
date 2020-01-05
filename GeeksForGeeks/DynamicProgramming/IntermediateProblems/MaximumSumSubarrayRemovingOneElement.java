class MaximumSumSubarrayRemovingOneElement {
    static int maxSumSubarrayRemovingOneEle(int arr[], int n) { 

        int fw[] = new int[n];
        int bw[] = new int[n];

        int cur_max = arr[0], max_so_far = arr[0];
        fw[0] = arr[0]; 
        for (int i = 1; i < n; i++) {
            cur_max = Math.max(arr[i], cur_max + arr[i]);
            max_so_far = Math.max(max_so_far, cur_max);
            fw[i] = cur_max;
        }

        cur_max = max_so_far = bw[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            cur_max = Math.max(arr[i], cur_max + arr[i]);
            max_so_far = Math.max(max_so_far, cur_max);
            bw[i] = cur_max; 
        } 

        int fans = max_so_far;

        for (int i = 1; i < n - 1; i++) {
            fans = Math.max(fans, fw[i - 1] + bw[i + 1]); 
        }

        return fans;
    }
}
