class MaximumProductSubarray {
    public void solve(int [] arr) {

        int minEndingHere = 1;
        int maxEndingHere = 1;

        int maxSoFar = 1;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > 0) {
                maxEndingHere = maxEndingHere * arr[i];
                minEndingHere = Math.min(minEndingHere * arr[i], 1);
                flag = 1;
            } else if (arr[i] == 0) {
                maxEndingHere = 1;
                minEndingHere = 1;
            } else {
                int temp = maxEndingHere;
                maxEndingHere = Math.max(minEndingHere * arr[i], 1);
                minEndingHere = temp * arr[i];
            }

            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }


        if (flag == 0 && maxEndingHere == 1) {
            return 0;
        }

        return maxSoFar;
    }
}
