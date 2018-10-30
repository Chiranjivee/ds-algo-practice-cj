import java.util.Arrays;

class Solution {
    public void quickSort(int [] arr, int start, int end) {
        if (start >= end) return;
        int pivot = partition(arr, start, end, end);
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    public int partition(int [] arr, int start, int end, int keyPos) {
        for (int i = start; i < end; i++) 
            if (arr[i] >= arr[keyPos] && i <= keyPos || arr[i] <= arr[keyPos] && i >= keyPos)
                keyPos = swap(arr, i, keyPos);

        return keyPos;
    }

    public int swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return i;
    }

    public static void main(String[] args) {
        int [] arr = {2, 1, 3, 4, 5};
        Solution sol = new Solution();
        sol.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
