class SortedPrintingOfBST {
    public void print(int [] arr, int start, int end) {
        if (start > end) {
            return;
        }

        print(arr, start * 2 + 1, end);
        System.out.println(arr[start]);
        print(arr, start * 2 + 2, end);
    }
}
