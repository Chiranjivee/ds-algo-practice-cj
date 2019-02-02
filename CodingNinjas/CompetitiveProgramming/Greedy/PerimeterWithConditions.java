import java.util.Arrays;
import java.util.Scanner;

public class PerimeterWithConditions {
    
    public static void main(String[] args) {
      	Scanner sc = new Scanner(System.in);
      	int n = sc.nextInt();
      	int [] arr = new int [n];
      	for (int i = 0; i < n; i++) {
          	arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
      
      	for (int i = n - 1; i >= 2; i--) {
          	for (int j = i - 1; j >= 1; j--) {
              	for (int k = j - 1; k >= 0; k--) {
                  	if (canFormTriangle(arr[k], arr[j], arr[i])) {
                      	System.out.println(arr[k] + " " + arr[j] + " " + arr[i]);
                      	return;
                    }
                }
            }
        }
		System.out.println(-1);
    }
    
  	public static boolean canFormTriangle(int a, int b, int c) {
      	return (a + b) > c && (b + c) > a && (a + c) > b;
    }
}
