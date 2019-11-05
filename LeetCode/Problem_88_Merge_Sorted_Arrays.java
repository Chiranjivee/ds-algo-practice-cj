/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) 
 * to hold additional elements from nums2.
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;   

        int num1Left = nums1.length - nums2.length - 1;
        int num2Left = nums2.length - 1;
        
        for (int i = nums1.length - 1; i >= 0; i--) {            
            if (num1Left < 0) {
                nums1[i] = nums2[num2Left--];
            } else if (num2Left < 0)  {
                nums1[i] = nums1[num1Left--];
            } else {
                nums1[i] = Math.max(nums1[num1Left], nums2[num2Left]);
                if (nums1[num1Left] > nums2[num2Left]) {
                    num1Left--;
                } else {
                    num2Left--;
                }
            }
        }
    }
}
