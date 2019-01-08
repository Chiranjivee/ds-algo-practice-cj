public class FindUnique {
	public static int findUnique(int[] arr){
      	int num = 0;
		for (int i = 0; i < arr.length; i++) {
          	num ^= arr[i];
        }
      	return num;
	}
}
