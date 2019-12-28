import java.util.Arrays;

class MoveNegativeElementsToEndWithExtraSpace {
    
    public void moveNegativeElements(int [] arr) {
        int start = 0;
        int [] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                temp[start++] = arr[i];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                temp[start++] = arr[i];
            }
        }

        System.out.println(Arrays.toString(temp));
    }
}
