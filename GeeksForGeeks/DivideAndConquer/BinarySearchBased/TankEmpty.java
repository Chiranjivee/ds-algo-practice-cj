class TankEmpty {
    public int getTimeWhenTankEmpty(int C, int l) {
        if (C <= l) {
            return C;
        }

        int start = 0;
        int end = Integer.MAX_VALUE;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (getSumOfN(mid) >= C - 1) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return l + mid;
    }

    public int getSumOfN(int n) {
        return n * (n + 1) / 2;
    }
}
