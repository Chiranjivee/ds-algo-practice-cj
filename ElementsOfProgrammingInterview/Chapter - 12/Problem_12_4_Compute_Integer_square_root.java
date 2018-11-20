/**
 * Given an integer compute you need to find largest integer
 * whose square is equal to or less than that number.
 */
class IntegerSquareRoot {
    public static int largestIntegerSquareClosestToN(int n) {
        int start = 0; 
        int end = n;
        
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            int midSquared = mid * mid;
            if (n == midSquared) return mid;
            else if (midSquared < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(largestIntegerSquareClosestToN(6));
    }
}
