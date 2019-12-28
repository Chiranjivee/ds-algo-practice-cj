/**
 * 
 * Given an array of integers of size n. Assume ‘0’ as invalid number and all other as
 *  valid number. Convert the array in such a way that if next number is a valid number
 *  and same as current number, double its value and replace the next number with 0.
 * 
 *  After the modification, rearrange the array such that all 0’s are shifted to the end.
 * 
 */
class DoubleFirstElementAndMoveZeroToEnd {
    public void solve(int [] arr) {
        int n = arr.length;
        if (n == 1) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] != 0 && arr[i] == arr[i + 1]) {
                arr[i] *= 2;
                arr[i + 1] = 0;
            }
        }

        pushZeroesToEnd(arr);
    }

    public void pushZeroesToEnd(int [] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[count++] = arr[i];
            }
        }

        while (count < arr.length) {
            arr[count] = 0;
        }
    }
}