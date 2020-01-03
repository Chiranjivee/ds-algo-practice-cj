class LongestIncreasingOddEvenSequence {
    public int getLongestIncreasingOddEvenSeq(int [] arr) {
        int [] lioes = new int[arr.length];
        Arrays.fill(lioes, 1);

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && (arr[i] + arr[j] % 2 != 0 && lioes[i] < lioes[j] + 1) {
                    lioes[i] = lioes[j] + 1;
                }
            }
        }

        int res = Integer.MIN_VALUE;
        for (int 0; i < lioes.length; i++) {
            res = Math.max(res, lioes[i]);
        }

        return res;
    }
}
