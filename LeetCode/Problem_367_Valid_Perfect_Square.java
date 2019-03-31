class Solution {
    public boolean isPerfectSquare(int x) {
        if (x == 0 || x == 1) return true;
        int start = 1;
        int end = x;
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
