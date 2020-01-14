class MinimumProductSubsetInArray {
    static int minProductSubset(int a[], int n) {
        if (n == 1)
            return a[0];
        int negmax = Integer.MIN_VALUE;
        int posmin = Integer.MAX_VALUE;
        int count_neg = 0, count_zero = 0;
        int product = 1;
    
        for (int i = 0; i<n; i++) {
            if (a[i] == 0) {
                count_zero++;
                continue;
            }

            if (a[i]<0) {
                count_neg++;
                negmax = Math.max(negmax, a[i]);
            }
    
            // find the minimum positive number 
            if (a[i] > 0 && a[i]<posmin)
                posmin = a[i];
    
            product *= a[i];
        }
    
        // if there are all zeroes 
        // or zero is present but no  
        // negetive number is present 
        if (count_zero == n || (count_neg == 0 && count_zero > 0))
            return 0;
    
        // If there are all positive 
        if (count_neg == 0)
            return posmin;
    
        // If there are even number except  
        // zero of negative numbers  
        if (count_neg % 2 == 0 && count_neg != 0) {
    
            // Otherwise result is product of 
            // all non-zeros divided by maximum 
            // valued negative. 
            product = product / negmax;
        }
    
        return product;
    }
}
