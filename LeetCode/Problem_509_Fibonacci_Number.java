class Solution {
    public int fib(int N) {
        if (N == 0) return 0;
        
        int a = 0;
        int b = 1;
        
        int n = 2;
        while (n <= N) {
            int c = a + b;
            a = b; b = c;
            n++;
        }
        return b;
    }
}
