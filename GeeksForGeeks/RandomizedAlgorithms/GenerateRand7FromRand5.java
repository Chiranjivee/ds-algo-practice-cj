class GenerateRand7FromRand5 {
    Random random = new Random();
    public int getRandom() {
        int candidate = 5 * rand5() - rand5() - 5;
        if (candidate < 22) {
            return candidate % 7 + 1;
        }

        return getRandom();
    }

    public int rand5() {
        return 1 + random.nextInt(4);
    }
}
