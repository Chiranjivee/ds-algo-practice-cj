class Shuffle2NIntegers {
    public void rearrange(int [] arr) {
        if (arr == null || arr.length % 2 == 1)
            return;

        int currIdx = (arr.length - 1) / 2;

        while (currIdx > 0) {
            int count = currIdx, swapIdx = currIdx;
        
            while (count-- > 0) {
                int temp = arr[swapIdx + 1];
                arr[swapIdx + 1] = arr[swapIdx];
                arr[swapIdx] = temp;
                swapIdx++;
            }
            currIdx--;
        }
    }
}