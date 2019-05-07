class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        subsets(nums, 0, new ArrayList<>(), result);
        return new ArrayList<>(result);
    }
    
    public void subsets(int [] nums, int idx, List<Integer> curr, Set<List<Integer>> res) {
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
