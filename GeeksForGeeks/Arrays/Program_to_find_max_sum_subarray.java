class Solution {
    public static void main(String[] args) {
        int [] arr = {-1 , -2, 4, -1, -2, 1, 3, -5};
        System.out.println("Max Sum of Sub-array:" + maxSumSubarray(arr));
    }
    public static int maxSumSubarray(int[] array) {
        int maxSoFar = Integer.MIN_VALUE;
        if (array.length == 0) return maxSoFar;
        if (array.length == 1) return array[0];
        int maxEndingHere = 0;
        for (int i = 0; i < array.length; i++) {
            maxEndingHere += array[i];
            maxEndingHere = maxEndingHere < 0 ? 0 : maxEndingHere;
            if (maxSoFar < maxEndingHere) maxSoFar = maxEndingHere;
        }
        return maxSoFar;
    }
}
