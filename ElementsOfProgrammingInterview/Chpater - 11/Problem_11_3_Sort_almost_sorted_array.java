import java.util.PriorityQueue;
import java.util.Arrays;

/**
 * k sorted array is an array 
 * in ewhich every element element is at max
 * k distance away from it's actual location.
 */
class SortKSorted {

    public int[] sortKSorted(int [] array, int k) {
        int [] result = new int [array.length];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            queue.offer(array[i]);
        }
        int resultIdx = 0;
        for (int i = k; i < array.length; i++) {
            queue.offer(array[i]);
            result[resultIdx++] = queue.poll();
        }
        while (!queue.isEmpty()) {
            result[resultIdx++] = queue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int [] input = {2, 1, 5, 4, 3};
        int k = 2;
        SortKSorted sorter = new SortKSorted();
        System.out.println(Arrays.toString(sorter.sortKSorted(input, k)));
    }
}