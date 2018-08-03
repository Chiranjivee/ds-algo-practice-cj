import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int [] sampleArray = {1, 2, 3, 4, 5};

	System.out.println("Printing sample array");
	System.out.println(Arrays.toString(sampleArray));

	System.out.println("Do binary search");
	System.out.println("Find key = 3, Result " + sol.binarySearch(sampleArray, 0, 4, 3) + ", Expected result " + 2);
	System.out.println("Find key = 1, Result " + sol.binarySearch(sampleArray, 0, 4, 1) + ", Expected result " + 0);
	System.out.println("Find key = 14, Result " + sol.binarySearch(sampleArray, 0, 4, 14) + ", Expected result " + -1);
	System.out.println("Find key = -12, Result " + sol.binarySearch(sampleArray, 0, 4, -12) + ", Expected result " + -1);
	System.out.println("Find key = -12, Result " + sol.binarySearch(new int[]{}, 0, 0, -12) + ", Expected result " + -1);
    }

    public int binarySearch(int [] array, int start, int end, int key) {
        if (start >= end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (array[mid] == key) {
            return mid;
        }

        return (array[mid] >= key) ? binarySearch(array, start, mid, key) : binarySearch(array, mid + 1, end, key);       
    }
}