class Solution {
    public int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                ans = mid;
                break;
            } else if (arr[start] <= arr[mid]) {
                if (target < arr[mid] && target >= arr[start])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else if (arr[mid] <= arr[end]) {
                if (target > arr[mid] && target <= arr[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return ans;
    }
}
