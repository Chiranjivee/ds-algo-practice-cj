/**
 * Given an array of elements of length N, ranging from 0 to N – 1. All elements may not be present in the array. 
 * If element is not present then there will be -1 present in the array. Rearrange the array such that A[i] = i and
 *  if i is not present, display -1 at that place.
 * 
 */
class RearrangeArraySuchThatArrIIsI {
    public void rearrange(int [] arr) {
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0 && i != arr[i]) {
                swap(arr, i, arr[i]);
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public int swap(int [] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}