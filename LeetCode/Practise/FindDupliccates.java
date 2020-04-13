class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            int currNum = nums[i];
            int itsIdx = Math.abs(currNum) - 1;

            if (nums[itsIdx] < 0) {
                result.add(Math.abs(currNum));
            } else {
                nums[itsIdx] = -nums[itsIdx];    
            }            
        }

        return result;
    }
}
