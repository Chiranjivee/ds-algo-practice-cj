class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {};
        }
        
        HashMap<Integer, Integer> set = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            set.put(nums[i], i);
        }
        
        int [] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            //System.out.println(x);
            if (set.containsKey(target - x)) {
                if (set.get(target - x) == i) continue;
                res[0] = i;
                res[1] = set.get(target - x);
                break;
            }
        }
        return res;
    }
}
