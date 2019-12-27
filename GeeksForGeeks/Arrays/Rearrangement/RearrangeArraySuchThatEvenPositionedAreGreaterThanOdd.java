import java.util.Arrays;

class RearrangeArray {
    public int[] rearrage(int [] arr) {
        Arrays.sort(arr);

        int [] temp = new int[arr.length];

        int q = arr.length - 1;
        for (int i = 1; i < arr.length; i += 2) {
            temp[i] = arr[q--];
        }

        int p = 0;
        for (int i = 0; i < arr.length; i += 2) {
            temp[i] = arr[p++];
        }
        return temp;
    }
}
