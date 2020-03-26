class SingleNumber  {
    public int getSingle(int  [] arr) {
        int xor = 0;
        for (int x : arr) {
            xor ^= x;
        }
        return xor;
    }
}
