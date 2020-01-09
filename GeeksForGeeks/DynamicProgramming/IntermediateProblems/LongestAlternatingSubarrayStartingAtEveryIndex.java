class LongestAlternatingSubarray {
    static void alternateSubarray(boolean arr[], int n) {
        int len[] = new int[n];
    
        // Initialize the base state of len[] 
        len[n - 1] = 1;
    
        // Calculating value for each element 
        for (int i = n - 2; i >= 0; --i) {
    
            // If both elements are different 
            // then add 1 to next len[i+1] 
            if (arr[i] ^ arr[i + 1] == true)
                len[i] = len[i + 1] + 1;
    
            // else initialize to 1 
            else
                len[i] = 1;
        }
    
        // Print lengths of binary subarrays. 
        for (int i = 0; i<n; ++i)
            System.out.print(len[i] + " ");
    }
}
