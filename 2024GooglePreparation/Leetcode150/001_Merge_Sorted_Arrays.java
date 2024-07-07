/**
 * Problem link - https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
 * 
 * Problem level - Easy
 *
 * 
 */
class Solution {

    /**
     * Approach: Fill bigger array from behind
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptr1 = m - 1;
        int ptr2 = n - 1;
        int k = nums1.length - 1;

        while (ptr1 >= 0 || ptr2 >= 0) {
            int option1 = ptr1 < 0 ? Integer.MIN_VALUE: nums1[ptr1];
            int option2 = ptr2 < 0 ? Integer.MIN_VALUE: nums2[ptr2];

            if (option1 > option2) {
                nums1[k--] = nums1[ptr1--];
            } else {
                nums1[k--] = nums2[ptr2--];
            }
        }
    }

    public static void main(String[] args) {}
}