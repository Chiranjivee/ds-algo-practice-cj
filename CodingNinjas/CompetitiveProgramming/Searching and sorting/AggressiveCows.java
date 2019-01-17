import java.util.Scanner;
import java.util.Arrays;

public class AggressiveCows {
	
	public static void main(String[] args) {
		// Write your code here
		Scanner sc = new Scanner(System.in);
      	int t = sc.nextInt();
      
      	for (int i = 0; i < t; i++ ) {
          	int n = sc.nextInt();
      		int c = sc.nextInt();
          	int [] distAr = new int[n];
          	for (int j = 0; j < n; j++) {
              	distAr[j] = sc.nextInt();
            }
          	Arrays.sort(distAr);
          	System.out.println(solve(distAr, c, n));
        }
	}
  
  	public static int solve(int [] distAr, int c, int n) {
      	int minDist = 0;
      	int maxDist = distAr[n - 1] - distAr[0];
      
		int result = 0;
      	int start = minDist;
      	int end = maxDist;
      
      	while (start <= end) {
          	int mid = (start + end) / 2;
          	if (canMidDistBeKept(distAr, mid, c)) {
              	result = mid;
              	start = mid + 1;
            } else {
              	end = mid - 1;
            }
        }
      
      	return result;
    }
  
  	public static boolean canMidDistBeKept(int[] distAr, int mid, int c) {
		int [] cowPos = new int [c];
      	// put 1st cow at 1st idx
      	cowPos[0] = 0;
      
      	int lastCowPos = 0;
      	// for remaining c-1 cows is it possible to put a cow
      	int cowsPut = 1;
      	for (int i = 1; i < distAr.length; i++) {
          	if (distAr[i] - distAr[lastCowPos] >= mid) {
              	lastCowPos = i;
              	cowsPut++;
            }
          	if (cowsPut == c) {
              	return true;
            }
        }
      	return false;
    }
}
