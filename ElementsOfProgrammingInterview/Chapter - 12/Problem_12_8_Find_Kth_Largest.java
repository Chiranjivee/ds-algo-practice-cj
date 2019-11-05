import java.util.Random;
import java.util.Arrays;

class KthLargest {
    public int kthLargest(int [] array,int start, int end, int k) {       
        int pivot = pivot(array, start, end);
        if (k - 1 == end - pivot) {
            return pivot;
        } else if (k - 1 > end - pivot) {
            return kthLargest(array, start, pivot, k - (end - pivot));
        }
        return kthLargest(array, pivot, end, k);
    }

    public int pivot(int [] array, int start, int end) {
        int pivotIndex = getRandomBetween(start, end);
        swap(array, pivotIndex, end);
        pivotIndex = end;
        for (int i = 0; i <= end; i++) {
            if (array[i] > array[pivotIndex] && i < pivotIndex) {
                swap(array, i, pivotIndex);
                pivotIndex = i;
            } else if (array[i] < array[pivotIndex] && pivotIndex < i) {
                swap(array, i, pivotIndex);
                pivotIndex = i;
            }
        }
        
        return pivotIndex;
    }

    public void swap(int [] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int getRandomBetween(int start, int end) {
        Random random = new Random();
        int randomNumber = start + random.nextInt(end - start + 1);
        return randomNumber;
    }

    public static void main(String[] args) {
        int [] input = { 44, 35, 101, 39, 21 };

        KthLargest kLargest = new KthLargest();
        int k = 4;
        int result = kLargest.kthLargest(input, 0, input.length - 1, k);
        System.out.println("Index of " + k + " largest: " + input[result]);
    }
}