class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        for (int k1 = Math.max(0, k - nums2.length); k1 <= Math.min(k, nums1.length); k1++) {
            int k2 = k - k1;
            int[] list1 = getlist(nums1, k1);
            int[] list2 = getlist(nums2, k2);
            int[] localresult = new int[k];
            help(list1, list2, localresult);
            if (comparelist(localresult, 0, result, 0))
                result = localresult;
        }
        return result;
    }

    private int[] getlist(int[] list, int k) {
        int[] result = new int[k];
        int len = 0;
        for (int index = 0; index < list.length; index++) {
            while (len > 0 && (k - len) < (list.length - index) && list[index] > result[len - 1])
                len--;
            if (len < k)
                result[len++] = list[index];
        }
        return result;
    }

    private void help(int[] list1, int[] list2, int[] result) {
        int index1 = 0, index2 = 0;
        int index = 0;
        while (index1 < list1.length && index2 < list2.length) {
            if (comparelist(list1, index1, list2, index2))
                result[index++] = list1[index1++];
            else
                result[index++] = list2[index2++];
        }
        while (index1 < list1.length)
            result[index++] = list1[index1++];
        while (index2 < list2.length)
            result[index++] = list2[index2++];
    }

    private boolean comparelist(int[] list1, int index1, int[] list2, int index2) {
        while (index1 < list1.length && index2 < list2.length) {
            if (list1[index1] > list2[index2])
                return true;
            if (list1[index1] < list2[index2])
                return false;
            index1++;
            index2++;
        }
        if (index1 < list1.length)
            return true;
        if (index2 < list2.length)
            return false;
        return true;
    }
}