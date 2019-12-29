class ConvertArrayToZigZagFashion {
    public void zigZag(int [] arr) {

        for (int i = 0; i < arr.length; i++) {

            boolean flag = true;
            if (flag) { // >
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            } else { // <
                if (arr[i] < arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }

            flag = !flag;
        }
    }
}
