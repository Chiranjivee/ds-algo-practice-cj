class MaxSumAlternatingSubsequence {
    public int getMaxSumAlternatingSubsequence(int[] arr) {
        int [] inc = new int[arr.length];
        int [] dec = new int[arr.length];

        dec[0] = arr[0];
        inc[0] = arr[0];

        int flag = 0;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    dec[i] = Math.max(dec[i], inc[j] + arr[i]);
                    flag = 1;
                } else if (arr[j] < arr[i] && flag == 1) {
                    inc[i] = Math.max(inc[i], dec[j] + arr[i]); 
                }
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            res = Math.max(res, Math.max(dec[i], inc[i]));
        }
        return res;
    }
}
