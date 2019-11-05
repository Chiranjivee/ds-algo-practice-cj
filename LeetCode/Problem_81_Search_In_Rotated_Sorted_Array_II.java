class Solution {
    public boolean search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return true;
            
            }
            // If we know for sure left side is sorted or right side is unsorted
            else if (arr[start] < arr[mid] || arr[mid] > arr[end]) {
                if (target < arr[mid] && target >= arr[start])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            //If we know for sure right side is sorted or left side is unsorted
            else if (arr[mid] < arr[end] || arr[mid] < arr[start]) {
                if (target > arr[mid] && target <= arr[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
            //If we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
            //any of the two sides won't change the result but can help remove duplicate from
            //consideration, here we just use end-- but left++ works too
            else {
                end--;
            }
        }
        return false;
    }
}
