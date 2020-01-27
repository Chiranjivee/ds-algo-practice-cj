class CheckIsAP {
    static boolean checkIsAP(int arr[], int n) {
        if (n == 1)
            return true;
    
        // Sort array 
        Arrays.sort(arr);
    
        // After sorting, difference between 
        // consecutive elements must be same. 
        int d = arr[1] - arr[0];
        for (int i = 2; i<n; i++)
            if (arr[i] - arr[i - 1] != d)
                return false;
    
        return true;
    }
}
