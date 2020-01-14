class ReservoirSampling {
    public int [] getKFromStream(int [] arr) {
        int [] reserve = new int[k];
        for (int i = 0; i < k; i++) {
            reserve[i] = arr[i];
        }

        for (int i = k; i < arr.length; i++) {
            int currElement = arr[i];
            int randIdx = random.nextInt(i);
            if (randIdx < k) {
                swap(reserve, randIdx, currElement);
            }
        }

        return reserve;
    }
}
