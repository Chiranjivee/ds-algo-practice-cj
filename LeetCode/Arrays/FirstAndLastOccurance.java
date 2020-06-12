class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        int firstOcc = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                if (mid == 0) {
                    firstOcc = mid;
                    break;
                } else if (mid != 0 && nums[mid - 1] != nums[mid]) {
                    // this is the first occurance
                    firstOcc = mid;
                    break;
                } else {
                    end = mid - 1;
                }
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        int secondOcc = -1;
        start = 0;
        end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1) {
                    secondOcc = mid;
                    break;
                } else if (mid != nums.length - 1 && nums[mid + 1] != nums[mid]) {
                    secondOcc = mid;
                    break;
                } else {
                    start = mid + 1;
                }
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return new int[] { firstOcc, secondOcc };
    }
}
