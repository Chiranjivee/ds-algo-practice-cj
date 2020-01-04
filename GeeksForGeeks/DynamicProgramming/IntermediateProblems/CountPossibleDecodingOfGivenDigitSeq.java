class CountPossibleDecodingOfGivenDigitSeq {
    public int countWays(String digits) {
        char [] dig = digits.toCharArray();

        int [] count = new int[dig.length];
        int n = dig.length;
        if (dig[0] == '0') return 0;

        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (dig[i - 1] != '0') {
                count[i] = count[i - 1];
            }

            if (dig[i - 2] == '1' || dig[i - 2] == '2' && dig[i - 1] >= 0 && dig[i - 1] <= 6) {
                count[i] += count[i - 2];
            }
        }

        return count[n];
    }
}
