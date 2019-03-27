import java.util.Arrays;

class Solution {

    /**
     * Complexity O(N)
     * 
     * @param nums
     * @param val
     * @return
     */
    public int removeElementInLinearTime(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /**
     * Complexity O(nlgn)
     * 
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        Arrays.sort(nums);
        int key = Arrays.binarySearch(nums, val);
        if (key < 0) {
            return nums.length;
        }

        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                start = i;
                break;
            }
        }

        int end = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == val) {
                end = i;
                break;
            }
        }

        int shift = end - start + 1;
        for (int i = end + 1; i < nums.length; i++) {
            nums[i - shift] = nums[i];
        }

        return nums.length - shift;
    }
}
