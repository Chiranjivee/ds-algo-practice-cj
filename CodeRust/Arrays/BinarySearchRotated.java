class BinarySearchRotated {

    int search(int [] input, int start, int end, int key) {
        if (start > end) {
            return -1;
        }  
        int mid = start + (end - start) / 2;
        if (input[mid] == key) {
            return mid;
        }
        if (input[start] < input[mid] && key > input[start] && key < input[mid]) {
            return search(input, start, mid - 1, key);
        } else if (input[mid] < input[end] & key > input[mid] && key < input[end]) {
            return search(input, mid + 1, end, key);
        } else if (input[start] > input[mid]) {
            return search(input, start, mid - 1, key);
        } else if (input[end] < input[mid]) {
            return search(input, mid + 1, end, key);
        }

        return -1;
    }
    public static void main(String[] args) {
        int [] input = { 23, 44, 55, 1, 10 };
        BinarySearchRotated searchRotated = new BinarySearchRotated();
        System.out.println("Search 1: " + searchRotated.search(input, 0, input.length - 1, 1));
    }
}