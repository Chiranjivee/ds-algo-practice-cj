public class Solution {
    public int getLargestSumSubarray(int [] arr){ 
        
        int maxEndingHere = 0;
        int maxSoFar = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + arr[i], 0);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        if (maxSoFar == 0) {
            return max;
        }

        return maxSoFar;
    }
}