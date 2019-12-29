class ThreeWayPartition {
    public void threeWayPartition(int [] arr, int lowValue, int highValue) {
        int start = 0;
        int end = arr.length - 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < lowValue) {
                swap(arr, i, start++);
            } else if (arr[i] > highValue) {
                swap(arr, i, end--);
            }
        }
    }
}