import java.util.Scanner;

public class WinningStrategy {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
      	
      	int n = sc.nextInt();
      	int [] arr = new int[n + 1];
      	for (int i = 0; i < n; i++) {
          	arr[i + 1] = sc.nextInt();
        }
      
      	int max = 0;
      	for (int i = 1; i < n + 1; i++) {
          	int diff = Math.abs(arr[i] - i);
          	if (diff > 2) {
              	System.out.println("NO");
              	return;
            }
        }
      
      	int count = 0;
      	for (int i = 1; i < n + 1; i++) {
          	int diff = Math.abs(arr[i] - i);
          	if (diff == 0) continue;
          	count += diff;

          	int k = i;
          	while (diff-- > 0) {
              	swap(arr, k, k + 1);
              	k++;
            }
          
          	if (arr[i] - i != 0) {
				diff = Math.abs(arr[i] - i);
          		count += diff;
	
	          	k = i;
	          	while (diff-- > 0) {
	              	swap(arr, k, k + 1);
	              	k++;
	            }
            }
        }

      	System.out.println("YES");
      	System.out.println(count);
	}
  
  	public static void swap(int [] arr, int i, int j) {
      	int temp = arr[i];
      	arr[i] = arr[j];
      	arr[j] = temp;
    }
}
