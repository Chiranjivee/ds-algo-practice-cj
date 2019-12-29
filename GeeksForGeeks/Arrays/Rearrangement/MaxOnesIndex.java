class MaxOnesIndex {
    public int maxOnesIndex(int [] arr) {
        int curr = 0;
        int prev = -1;
        int prevPrev = -1;
        int maxIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                if (curr - prevPrev > maxCount) {
                    maxCount = curr - prevPrev;
                    maxIndex = prev;
                }

                prevPrev = prev;
                prev = curr;
            }
        }

        return maxIndex;
    }
}