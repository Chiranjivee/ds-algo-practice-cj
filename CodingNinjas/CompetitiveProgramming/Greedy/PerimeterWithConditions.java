import java.util.Arrays;
import java.util.Scanner;

public class PerimeterWithCondition {
    
    public static void main(String[] args) {
      	Scanner sc = new Scanner(System.in);
      	int n = sc.nextInt();
      	int [] arr = new int [n];
      	for (int i = 0; i < n; i++) {
          	arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
      	for (int i = n - 1; i >= 2; i--) {
          	if (canFormTriangle(arr[i - 2], arr[i - 1], arr[i])) {
            	System.out.println(arr[i - 2] + " " + arr[i - 1] + " " + arr[i]);
	            return;
            }
        }
		System.out.println(-1);
    }
    
  	public static boolean canFormTriangle(int a, int b, int c) {
      	return (a + b) > c && (b + c) > a && (a + c) > b;
    }
}
