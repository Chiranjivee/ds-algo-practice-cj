/**
 * Given an array of n elements. Our task is to write a program to rearrange the array such that elements at 
 * even positions are greater than all elements before it and elements at odd positions are less than all 
 * elements before it.
 * 
 */
class RearrangeArray {
    public void rearrange(int [] arr) {

        int n = arr.length;
        int evenPos = n / 2;
        int oddPos = n - evenPos;

        int [] tempArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(tempArr);

        int j = oddPos - 1;
        for (int i = 0; i < arr.length; i += 2) {
            arr[i] = arr[j];
            j--;
        }

        j = oddPos;
        for (int i = 1; i < arr.length; i+= 2) {
            arr[i] = arr[j];
            j++;
        }

        System.out.println(Arrays.toString(arr));
    }
}
