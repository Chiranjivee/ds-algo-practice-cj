class CountMinCousequtiveSubsets {
    static int numofsubset(int arr[], int n) {
        // Sort the array so that elements 
        // which are consecutive in nature 
        // became consecutive in the array. 
        Arrays.sort(arr);
    
        // Initialize result 
        int count = 1;
        for (int i = 0; i < n - 1; i++) {
            // Check if there is beginning 
            // of another subset of 
            // consecutive number 
            if (arr[i] + 1 != arr[i + 1])
                count++;
        }
    
        return count;
    }    
}
