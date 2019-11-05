class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++)
            if (dividingNumber(i)) res.add(i);
        return res;
    }

    boolean dividingNumber(int num) {
        for (int n = num; n > 0; n /= 10) {
            int digit = n % 10;
            if (digit == 0 || num % (digit) != 0) return false;
        }
        return true;
    }
}
