import java.util.Scanner;
import java.util.Arrays;

public class InterestingSequence {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
      	int n = sc.nextInt();
      	int k = sc.nextInt();
      	int l = sc.nextInt();
      
      	int [] arr = new int[n];
      	int min = Integer.MAX_VALUE;
      	int max = Integer.MIN_VALUE;
      	for (int i = 0; i < n; i++) {
          	arr[i] = sc.nextInt();
          	if (arr[i] > max) max = arr[i];
          	if (arr[i] < min) min = arr[i];
        }

      	int minCost = Integer.MAX_VALUE;
      	for (int i = min; i <= max; i++) {
          	int elementCost = getElementCost(arr, i, k, l);
        	if (elementCost < minCost) minCost = elementCost;
        }
      	System.out.println(minCost);
	}
  
  	public static int getElementCost(int [] arr, int i, int k, int l) {
    	int cost = 0;
      	int inc = 0, dec = 0;
      	for (int e : arr) {
	        if (e > i) dec += (e - i);
	        else inc += (i - e);
	    }

      	if (inc >= dec) {
	    	cost += (dec * k);
	      	cost += (inc - dec) * l;
          	return cost;
        }

      	return Integer.MAX_VALUE;
    }
}
