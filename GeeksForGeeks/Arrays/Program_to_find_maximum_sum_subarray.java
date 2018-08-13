class Solution {
    public static void main(String[] args) {
        int [] arr = {-1 , -2, -4, -1, -2, -1, -3, -5};
        System.out.println("Max Sum of Sub-array:" + maxSumSubarray(arr));
    }
    public static int maxSumSubarray(int[] a) {
        if (a.length == 0) return Integer.MIN_VALUE;
        if (a.length == 1) return a[0];
        int currMax = a[0];
        int maxSoFar = a[0];
        for (int i = 1; i < a.length; i++) {
            currMax = Math.max(currMax, maxSoFar + a[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }
        return maxSoFar;
    }
}
