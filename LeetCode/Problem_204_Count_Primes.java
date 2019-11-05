class Solution {
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) if (isPrime(i)) count++;
        return count;
    }
    
    public boolean isPrime(int n) {
        if (n == 2) return true;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
