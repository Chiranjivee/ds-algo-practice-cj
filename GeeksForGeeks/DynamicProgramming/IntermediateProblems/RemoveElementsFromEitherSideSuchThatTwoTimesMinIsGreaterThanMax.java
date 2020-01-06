class RemoveElementsFromEitherSideSuchThatTwoTimesMinIsGreaterThanMax {
    static int minRemovalsDP(int arr[], int n) { 

        int longest_start = -1, longest_end = 0; 
        for (int start = 0; start < n; start++) { 
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int end = start; end < n; end++) { 
                int val = arr[end];
                if (val < min) {
                    min = val;
                }

                if (val > max) {
                    max = val;
                }

                if (2 * min <= max) {
                    break;
                }
  
                // Update longest_start and longest_end if needed  
                if (end - start > longest_end - longest_start || longest_start == -1) {
                    longest_start = start;
                    longest_end = end;
                }
            }
        }

        if (longest_start == -1) {
            return n;
        }
  
        // Return the number of elements to be removed  
        return (n - (longest_end - longest_start + 1)); 
    }
}
