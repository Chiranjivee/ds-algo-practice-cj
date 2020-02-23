import java.util.Arrays;

class BubbleSorter {

    public static void main(String [] args) {
        int [] arr = new int[] {3, 2, 1, 4, 5};
        BubbleSorter s = new BubbleSorter();
        System.out.println(Arrays.toString(arr));

        s.sortRec(arr, 0);
        System.out.println(Arrays.toString(arr));

    }

    public void sort(int [] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public void sortRec(int [] arr, int idx) {
        if (arr.length == idx) {
            return;
        }

        for (int j = 0; j < arr.length - 1 - idx; j++) {
            if (arr[j] > arr[j + 1]) {
                swap(arr, j, j + 1);
            }
        }

        sortRec(arr, idx + 1);
    }

    public void swap(int [] arr, int i, int j) {
        int temp  =arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
