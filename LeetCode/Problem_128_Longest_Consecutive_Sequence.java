class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer e : nums) set.add(e);
        
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            
            int left = nums[i] - 1;
            if (!set.contains(left)) {
                int current = nums[i];
                int tempCount = 0;
                while (set.contains(current)) {
                    tempCount++;
                    current++;
                }
                
                if (maxCount < tempCount) {
                    maxCount = tempCount;
                }
            }
        }
        return maxCount;
    }
}
