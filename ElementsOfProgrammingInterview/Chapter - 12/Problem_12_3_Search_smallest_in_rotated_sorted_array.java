class SearchRotated {
    public static int getSmallestInRotated(int [] input) {
        int start = 0;
        int end = input.length - 1;

        int mid = -1;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (input[mid] > input[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
    public static void main(String[] args) {
        int [] input = {4, 5, 1, 2, 3};
        System.out.println(getSmallestInRotated(input));
    }
}