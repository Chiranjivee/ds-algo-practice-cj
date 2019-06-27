class Solution {
    public int search(ArrayReader reader, int target) {
        int hi = 1;
        while (reader.get(hi) < target) {
            hi = hi << 1;
        }
        
        int low = hi >> 1;
        while (low <= hi) {
            int mid = low+(hi-low)/2;
            if (reader.get(mid) > target) {
                hi = mid-1;
            } else if (reader.get(mid) < target) {
                low = mid+1;
            } else {
                return mid;
            }
        }
        
        return -1;
    }
}
