class  Random6FromRandom01 {
    // generate number from 0 to 7
    public int getRand7() {
        int val = 0;
        for (int i = 0; i <= 2; i++) {
            int bit = getRandomZeroOne();
            val <<= 1;
            val |= bit;
        }
        return val;
    }
}
