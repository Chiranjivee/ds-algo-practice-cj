/**
 * Rearrange an array such that ‘arr[j]’ becomes ‘i’ if ‘arr[i]’ is ‘j’ 
 */
class RearrangeArray {
    public void rearrange(int [] arr) {

        for (int i = 0; i < arr.length; i++) {
            arr[i] += 1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                rearrangeUtil(arr, i);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = -(arr[i] + 1);
        }
    }

    // arr[i] = j then arr[j] = i
    public void rearrangeUtil(int [] arr, int i) {
        int n = arr.length;
        int nextValue = -i - 1;
        int nextIndex = arr[i] - 1;

        while (arr[nextIndex] > 0) {
            int nexIndex = arr[i] - 1;
            arr[i] = nextValue;

            nextValue = -(i + 1);
            nextIndex = newIndex;
        }
    }
}
