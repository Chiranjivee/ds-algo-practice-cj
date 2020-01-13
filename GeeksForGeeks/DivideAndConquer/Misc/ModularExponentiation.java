class Solution {
    static int power(int x, int y, int p) {
        // Initialize result 
        int res = 1;
    
        // Update x if it is more   
        // than or equal to p 
        x = x % p;
    
        while (y > 0) {
            if ((y & 1) == 1)
                res = (res * x) % p;

            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }
}
