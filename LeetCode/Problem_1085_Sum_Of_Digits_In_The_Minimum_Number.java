class Solution {
    public int sumOfDigits(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        int min = A[0];
        for (int a : A) {
            min = Math.min(min, a);
        }

        int sum = 0;

        while (min != 0) {
            sum += min % 10;
            min /= 10;
        }

        return sum % 2 == 0 ? 1 : 0;
    }
}
