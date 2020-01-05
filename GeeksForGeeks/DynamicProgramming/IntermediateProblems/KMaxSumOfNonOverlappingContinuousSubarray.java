class KMaxSumOfNonOverlappingContinuousSubarray {
    public int solve(int [] arr, int k) {

        for (int i = 0; i < k; i++) {
            int [] startEnd = getKadaneStartEnd(arr);
            System.out.println("Start:" + startEnd[0] + ", End: " + startEnd[1]);
            fillArrayWithNegInfFromStartToEnd(arr, startEnd[0], startEnd[1]);
        }
    }

    public int [] getKadaneStartEnd(int [] arr) {
        int maxEndingHere = 0;
        int maxSoFar = Integer.MIN_VALUE;
        int start = 0;
        int s = 0;
        int end = 0;

        for (int i = 0; i < arr.length; i++) {
            maxEndingHere = maxEndingHere + arr[i];
            if (maxEndingHere < 0) {
                s = i + 1;
                maxEndingHere = 0;
                continue;
            }

            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                start = s;
                end = i;
            }
        }

        return new int[] { start, end };
    }
}
