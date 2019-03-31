class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int start = 1;
        int end = x;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid <= x / mid && (mid + 1) > x /(mid + 1)) 
                return mid;
            else if (mid  > x / mid) 
                end = mid;
            else 
                start = mid + 1;
        }
        return start;
    }
}
