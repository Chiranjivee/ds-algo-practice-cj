class SegregateZeroAndOne {
    public void SegregateZeroAndOne(int [] arr) {
        int zero = 0;
        int one = arr.length - 1;

        while (zero < one) {
            if (arr[zero] == 1) {
                swap(arr, zero, one);
                one--;
            } else {
                zero++;
            }
        }
    }
}
