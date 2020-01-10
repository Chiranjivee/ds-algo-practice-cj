class BinarySearch {

    Random random = new Random();
    public int search(int [] arr, int key) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = getRandomInRange(start, end);
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    private int getRandomInRange(int start, int end) {
        int offset = end - start + 1;
        return start + random.nextInt(offset);
    }
}
