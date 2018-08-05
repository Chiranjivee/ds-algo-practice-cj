class Solution {
    public static void main(String[] args) {
        int [] array = {21, 23, 34, 45, 67};
        int [] keyToBeSearched = {10, 20, 30, 21, 23, 34, 28, 34, 44, 45, 67};
        int [] expectedOutcome = {-1, -1, -1, 0, 1, 2, -1, 2, -1, 3, 4};

        Solution sol = new Solution();
        for (int i = 0; i < keyToBeSearched.length; i++) {
            System.out.println("Expected Outcome: " + expectedOutcome[i] + ", Actual :" + sol.binarySearch(array, 0, 4, keyToBeSearched[i]));
        }
    }

    public int binarySearch(int [] array, int start, int end, int key) {
        if (start > end) {
            return -1;
        }


        int mid = (start + end) / 2;
        if (array[mid] == key) {
            return mid;
        }

        return array[mid] > key ? binarySearch(array, start, mid - 1, key) : binarySearch(array, mid + 1, end, key);
    }
}
