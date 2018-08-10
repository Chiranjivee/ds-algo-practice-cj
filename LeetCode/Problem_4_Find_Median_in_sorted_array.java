public class Solution {
    public static void main(String[] args) {
        int [] arr1 = {1, 3, 7, 11, 15};
        int [] arr2 = {2, 4, 9, 18, 21, 22};

        System.out.println("Median is : " + findMedianInSortedArrays(arr1, arr2) + ", Expected Result: " + 9.0);
    }

    public static double findMedianInSortedArrays(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length) {
            return findMedianInSortedArrays(arr2, arr1);
        }

        int m = arr1.length;
        int n = arr2.length;

        int start = 0;
        int end = m;
        while (start <= end) {
            int part_x = (start + end) / 2;
            int part_y = (m + n + 1) / 2 - part_x;

            int maxLeftX = part_x == 0 ? Integer.MIN_VALUE : arr1[part_x - 1];
            int minRightX = part_x == m ? Integer.MAX_VALUE : arr1[part_x];

            int maxLeftY = part_y == 0 ? Integer.MIN_VALUE : arr2[part_y - 1];
            int minRightY = part_y == n ? Integer.MAX_VALUE : arr2[part_y];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                return (m + n) % 2 == 0 ? (double)(Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2 : (double)Math.max(maxLeftX, maxLeftY);
            } else if (maxLeftX > minRightY) {
                end = part_x - 1;
            } else {
                start = part_x + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}