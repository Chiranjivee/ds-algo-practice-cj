class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return permuteUtil(nums, 0);
    }
    
    public List<List<Integer>> permuteUtil(int[] nums, int startIdx) {
        if (nums.length - 1 == startIdx) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> r = new LinkedList<>();
            r.add(Integer.valueOf(nums[startIdx]));
            res.add(r);
            return res;
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for (int i = startIdx; i < nums.length; i++) {
            swap(nums, i, startIdx);
            List<List<Integer>> temp = permuteUtil(nums, startIdx + 1);
            for (List<Integer> tempList : temp) {
                tempList.add(0, Integer.valueOf(nums[startIdx]));
                result.add(tempList);
            }

            swap(nums, i, startIdx);
        }
        return result;
    }
    
    public void swap(int [] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
