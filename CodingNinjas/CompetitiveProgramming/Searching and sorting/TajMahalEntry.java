import java.util.*;

public class TajMahalEntry {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int window = in.nextInt();
      	int [] windows = new int[window];
      	for (int i = 0; i < window; i++) {
			windows[i] = in.nextInt();
        }
      
      	int result = computeFirstIteration(windows);
      	if (result >= 0) {
          	System.out.println(result + 1);
          	return;
        }
      	
        boolean done = false;
      	while (!done) {
          	int next = computeNextIteration(windows);
          	if (next >= 0) {
              	System.out.println(next + 1);
              	done = true;
            }
        }
	}
  	
  	public static int computeFirstIteration(int [] arr) {
      	for (int i = 0; i < arr.length; i++) {
          	int element=  arr[i];
          	int test = element - i;
          	if (test <= 0) {
              	return i;
            }
        }
      
      	return -1;
    }
  
  	public static int computeNextIteration(int [] arr) {
      	int len = arr.length;
      	for (int i = 0; i < arr.length; i++) {	
        	if (i != arr.length - 1)
                arr[i] = arr[i] - i - len;
            else arr[i] = arr[i] - i - len + 1;
          	if (arr[i] <= 0) {
              	return i;
            }
        }
      	return -1;
    }
}