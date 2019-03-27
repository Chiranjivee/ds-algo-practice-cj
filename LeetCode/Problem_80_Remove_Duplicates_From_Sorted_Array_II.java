class Solution {
    /**
     * Two pointer technique
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int i = 1;
        for (int j = 2; j < nums.length; j++) {
            if (nums[j] != nums[i] || nums[j] != nums[i - 1]) {
                i++;
                nums[i] = nums[j];
            } 
        }

        return i + 1;
    }
}
