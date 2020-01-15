class Solution {
    static void minAbsSumPair(int arr[], int n) {
        // Variables to keep track of current sum and minimum sum 
        int sum, min_sum = 999999;
    
        // left and right index variables 
        int l = 0, r = n - 1;
    
        // variable to keep track of the left and right pair for min_sum 
        int min_l = l, min_r = n - 1;
    
        /* Array should have at least two elements*/
        if (n<2) {
            System.out.println("Invalid Input");
            return;
        }
    
        /* Sort the elements */
        sort(arr, l, r);
    
        while (l<r) {
            sum = arr[l] + arr[r];
    
            /*If abs(sum) is less then update the result items*/
            if (Math.abs(sum)<Math.abs(min_sum)) {
                min_sum = sum;
                min_l = l;
                min_r = r;
            }
            if (sum<0)
                l++;
            else
                r--;
        }
    
        System.out.println(" The two elements whose " + "sum is minimum are " + arr[min_l] + " and " + arr[min_r]);
    }
}