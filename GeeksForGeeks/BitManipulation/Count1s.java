class Count1s {
    public int count(int x) {
        int result = 0;
        while (x != 0) {
            x = x & (x - 1);
            result++;
        }
        return result;
    }
}
