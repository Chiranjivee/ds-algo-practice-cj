class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int [] res = new int[n];
        for (int [] booking: bookings) {
            int start = booking[0] - 1;
            int end = booking[1] - 1;
            int count = booking[2];
            
            res[start] += count;
            if (end < res.length - 1) {
                res[end + 1] -= count; 
            }
        }
        
        for (int i = 1; i < res.length; i++) {
            res[i] += res[i - 1];
        }
        return res;
    }
}
