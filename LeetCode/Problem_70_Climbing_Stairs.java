class Solution {
    public int climbStairs(int n) {
        int a = 1;
        int b = 2;

        if (n == 1) return a;
        if (n == 2) return b;
        
        int next = 0;
        for (int i = 2; i < n; i++) {
            next = a + b;
            a = b;
            b = next;
        }
        
        return next;
    }
}
