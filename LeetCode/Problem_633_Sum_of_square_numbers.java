class Solution {
    public boolean judgeSquareSum(int c) {
        if (c == 0) {
            return true;
        }
        int limit = (int) Math.sqrt(c);
        for (int i = 1; i <= limit + 1; i++) {
            int i_2 = i * i;
            boolean ans = checkIfJ2Exists(i, limit + 1, c - i_2);
            if (ans) {
                return true;
            }
        }
        
        return false;
    }

    public boolean checkIfJ2Exists(int s, int e, int x) {
        if (x == 0 || x == 1) return true;
        int start = s;
        int end = e;
        while (start < end) {
            double mid = (start + end) / 2;
            if (mid == (x / mid)) 
                return true;
            else if (mid  > (x / mid)) 
                end = (int) mid;
            else 
                start = (int) mid + 1;
        }
        return false;
    }
}
