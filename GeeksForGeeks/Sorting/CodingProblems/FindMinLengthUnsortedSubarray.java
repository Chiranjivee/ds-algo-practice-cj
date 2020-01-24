class FindMinLengthUnsortedSubarray {
    static void printUnsorted(int arr[], int n) {
        int s = 0, e = n - 1, i, max, min;
    
        // step 1(a) of above algo 
        for (s = 0; s<n - 1; s++) {
            if (arr[s] > arr[s + 1])
                break;
        }

        if (s == n - 1) {
            System.out.println("The complete array is sorted");
            return;
        }
    
        // step 1(b) of above algo 
        for (e = n - 1; e > 0; e--) {
            if (arr[e] < arr[e - 1])
                break;
        }
    
        // step 2(a) of above algo 
        max = arr[s];
        min = arr[s];
        for (i = s + 1; i<= e; i++) {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i]<min)
                min = arr[i];
        }
    
        // step 2(b) of above algo 
        for (i = 0; i<s; i++) {
            if (arr[i] > min) {
                s = i;
                break;
            }
        }
    
        // step 2(c) of above algo 
        for (i = n - 1; i >= e + 1; i--) {
            if (arr[i]<max) {
                e = i;
                break;
            }
        }
    
        // step 3 of above algo 
        System.out.println(" The unsorted subarray which makes the given array sorted lies between the indices " + s + " and " + e);
        return;
    }
}
