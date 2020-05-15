class Solution {
    public int majorityElement(int[] nums) {
        Integer candidate = null;
        int count = 0;
        
        for (int i : nums) {
            if (count == 0) {
                candidate = i;
            }
            
            count += (candidate == i) ? 1 : -1;
        }
        
        return candidate;
    }
}
