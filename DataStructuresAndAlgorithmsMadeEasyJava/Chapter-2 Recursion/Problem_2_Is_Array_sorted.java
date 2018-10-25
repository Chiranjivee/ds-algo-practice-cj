import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int [] test = { 1, 2, 0 };
        System.out.println("Input array is: " + Arrays.toString(test));
        System.out.println("Sorted: " + isArraySorted(test, test.length));  

        int [] test2 = { 1, 2 };
        System.out.println("Input array is: " + Arrays.toString(test2));
        System.out.println("Sorted: " + isArraySorted(test2, test2.length));
    }

    public static boolean isArraySorted(int [] array, int index) {
        if (index == 1) {
            return true;
        }

        return 
            array[index - 2] < array[index - 1] ? 
            isArraySorted(array, index - 1) : 
            false;
    }
}
