import java.util.Arrays;

class Solution {
    public void mergeSort(int [] inp) {
        split(inp, 0, inp.length - 1);
    }

    public void split(int [] arr, int start, int end) {
        if (start >= end) return;

        int mid = (start + end) / 2;
        split(arr, start, mid);
        split(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public void merge(int[] input, int start, int mid, int end) {
        int[] leftArray = Arrays.copyOfRange(input, start, mid + 1);
        int[] rightArray = Arrays.copyOfRange(input, mid + 1, end + 1);

        int leftArrayIndex = 0, rightArrayIndex = 0, mergedSubArrayIndex = start;

        while (leftArrayIndex < leftArray.length || rightArrayIndex < rightArray.length)
            input[mergedSubArrayIndex++] = 
                leftArrayIndex >= leftArray.length ? 
                    rightArray[rightArrayIndex++] :
                rightArrayIndex >= rightArray.length ? 
                    leftArray[leftArrayIndex++] : 
                leftArray[leftArrayIndex] <= rightArray[rightArrayIndex] ?
                     leftArray[leftArrayIndex++] :
                     rightArray[rightArrayIndex++];
    }

    public static void main(String[] args) {
        int [] arr = {5, 5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 2, 2, 1};
        Solution sol = new Solution();
        sol.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
