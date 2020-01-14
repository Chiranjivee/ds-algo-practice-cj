class Shuffle {
    public void shuffle(int [] arr) {
        int n = arr.length;
        for (int i = n - 1; i > 0; i--) {
            int randIdx = getRandomIdxBetween(0, i - 1);
            swap(arr, i, randIdx);
        }
    }

    public int getRandomIdxBetween(int x) {
        return random.nextInt(x);
    }
}
