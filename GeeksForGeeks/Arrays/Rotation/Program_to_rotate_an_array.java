import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int [] input = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(rotateArrayByK(input, 2)));
    }

    public static void rotateArray(int [] arr, int k) {
        int n = arr.length;
        int backup = arr[0];
        int i = 0;
        while (n-- > 0) {
            arr[i++] = arr[k++ % arr.length];
        }

        return arr;
    }

    public static int [] rotateArrayByK(int [] array, int k) {
        int rotateBy = k % array.length;
        if (rotateBy == 0) {
            return array;
        }

        int [] temp = new int[rotateBy];
        for (int i = 0; i < rotateBy; i++) {
            temp[i] = array[i];
        }

        int start = 0;
        for (int i = rotateBy; i < array.length; i++) {
            array[start] = array[i];
            start++;
        }

        for (int i = 0; i < rotateBy; i++) {
            array[start] = temp[i];
            start++;
        }

        return array;
    }
}
