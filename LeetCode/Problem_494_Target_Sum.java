class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<String, Integer> map = new HashMap<>();
        return findTargetSumWays(nums, 0, S, 0, map);
    }
    
    public int findTargetSumWays(int [] nums, int pos, int S, int sum, HashMap<String, Integer> map) {
        String encodeString = pos + "->" + sum;
        if (map.containsKey(encodeString)){
            return map.get(encodeString);
        }

        if (pos == nums.length) {            
            if (S == sum) {
                return 1;
            }

            return 0;
        }

        
        int option1 = findTargetSumWays(nums, pos + 1, S, sum + nums[pos], map);
        int option2 = findTargetSumWays(nums, pos + 1, S, sum - nums[pos], map);
        map.put(encodeString, option1 + option2);
        return option1 + option2;
    }
}
