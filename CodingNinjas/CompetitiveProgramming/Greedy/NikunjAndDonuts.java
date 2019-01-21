import java.util.*;

public class NikunjAndDonuts {

	public static void main(String[] args) {
		// Write your code here
		Scanner sc = new Scanner(System.in);
      	int n = sc.nextInt();	
      	int [] arr = new int [n];
      	for (int i = 0; i < n; i++) {
          	arr[i] = sc.nextInt();
        }
      
      	Arrays.sort(arr);
      	long sum = 0;
      	for (int i = 0; i < n; i++) {
          	sum += arr[i] * Math.pow(2, n - 1 - i);
        }
      	System.out.println(sum);
	}
}