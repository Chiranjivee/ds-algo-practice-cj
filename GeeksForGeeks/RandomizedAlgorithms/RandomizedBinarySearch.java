class BSearch {
    Random random = new Random();
    public int binarySearch(int [] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
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

    public int getRandomIdx(int start, int end) {
        return start + random.nextInt(end - start + 1);
    }
}
