class SumOfAllSubstringsOfAStringNumber {
    public int getSum(String number) {
        int [] dp = new int[number.length()];
        dp[0] = number.charAt(0) - '0';

        int res = dp[0];
        for (int i = 1; i < number.length(); i++) {

            int num = number.charAt(i) - '0';
            dp[i] = 10 * dp[i - 1] + (i + 1) * num;
            res += dp[i];
        }

        return res;
    }
}
