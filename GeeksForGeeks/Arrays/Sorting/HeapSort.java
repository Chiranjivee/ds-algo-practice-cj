import java.util.Arrays;

class Solution {
    public void heapSort(int [] arr) {
        int heapSize = arr.length;
        heapify(arr, heapSize, 0);
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, --heapSize, 0);
        }
    }

    public void heapify(int [] input, int heapSize, int heapRoot) {
        int start = (int) Math.floor(heapSize / 2) - 1;
        for (int j = start; j >= 0; j--) {
            int leftIndex = getLeft(j);
            int rightIndex = getRight(j);
            int largest = j;

            if (leftIndex < heapSize && input[leftIndex] > input[j]) largest = leftIndex;
            if (rightIndex < heapSize && input[rightIndex] > input[j]) largest = rightIndex;

            if (largest != j) {
                swap(input, largest, j);
                heapify(input, heapSize, largest);
            }
        }
    }

    public int getLeft(int i) {
        return 2 * i + 1;
    }

    public int getRight(int i) {
        return 2 * i + 2;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int [] arr = {5, 4, 3, 2, 1};
        Solution sol = new Solution();
        sol.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}