class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsets(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    public void subsets(int [] nums, int idx, List<Integer> curr, List<List<Integer>> res) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        subsets(nums, idx + 1, curr, res);
        curr.add(nums[idx]);
        subsets(nums, idx + 1, curr, res);
        curr.remove(curr.size() - 1);
    }
}
