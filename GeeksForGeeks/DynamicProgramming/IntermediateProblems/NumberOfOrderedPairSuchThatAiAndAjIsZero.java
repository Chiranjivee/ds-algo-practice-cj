class Solution {
    static int countPairs(int a[], int n) {
        int count = 0;
    
        // check for all possible pairs 
        for (int i = 0; i<n; i++) {
            for (int j = i + 1; j<n; j++)
                if ((a[i] & a[j]) == 0)
    
                    // add 2 as (i, j) and (j, i) are 
                    // considered different 
                    count += 2;
        }
    
        return count;
    }
}
