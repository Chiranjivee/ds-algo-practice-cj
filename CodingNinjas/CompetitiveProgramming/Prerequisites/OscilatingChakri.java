import java.util.Scanner;

/**
 * A variant of stock problem with one transaction.
 */
public class OscilatingChakri {
	public static void main(String[] args) {
		// Write your code here
		Scanner sc = new Scanner(System.in);
      	int n = sc.nextInt();
      	int arr[] = new int [n];
      	for (int i = 0; i < n; i++) {
          	arr[i] = sc.nextInt();
        }
      
      	int minSoFar = Integer.MAX_VALUE;
      	int currentProfit = 0;
      	int maxProfit = 0;
      	for (int i = 0; i < n; i++) {
          	if (minSoFar > arr[i]) {
              minSoFar = arr[i];
            }

            currentProfit = arr[i] - minSoFar;
            if (maxProfit < currentProfit) {
              maxProfit = currentProfit;
            }
        }
      	System.out.println(maxProfit);
	}
}
