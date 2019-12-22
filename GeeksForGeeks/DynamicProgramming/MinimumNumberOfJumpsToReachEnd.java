class MinimumNumberOfJumpsToReachEnd {
    public int getMinJumps(int [] arr) {
        int n = arr.length;
        int [] jumps = new int[n];
        jumps[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] == 0) {
                jumps[i] = Integer.MAX_VALUE;
                continue;
            }

            if (i + arr[i] >= n - 1) {
                jumps[i] = 1;
                continue;
            }

            int options = arr[i];
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= options; j++) {
                // this means unrechable point, dont consider
                if (jumps[i + j] != Integer.MAX_VALUE) {
                    min = Math.min(min, jumps[i + 1]);
                }
            }

            jumps[i] = min == Integer.MAX_VALUE ? min : ++min;
        }

        return jumps[0];
    }
}
