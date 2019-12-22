class MaxSumIn2ByNGridWithNoAdjacents {
    public int getMaxWithConstantSpace(int [][] arr) {
        
        if (arr.length == 0) {
            return 0;
        }

        if (arr.length == 1) {
            return Math.max(arr[0][0], arr[1][0]);
        }

        int secLast = Math.max(arr[0][0], arr[1][0]);
        int last = Math.max(secLast, Math.max(arr[0][1], arr[1][1]));

        int result = last;
        for (int i = 2; i < arr.length; i++) {
            result = Math.max(last, Math.max(arr[0][i], arr[1][i]) + secLast);
            secLast = last;
            last = result;
        }

        return result;
    }
}
