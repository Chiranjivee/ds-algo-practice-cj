public class ArrayRotate {	
	public static void rotate(int[] arr, int d) {
		int temp[] = new int[d];
      	for (int i = 0; i < d; i++) {
          	temp[i] = arr[i];
        }
        for (int i = d, j = 0; i < arr.length; i++, j++) {
          	arr[j] = arr[i];
        }
      	for (int i = arr.length - d, j = 0; i < arr.length; i++, j++) {
          	arr[i] = temp[j];
        }
	}
}
