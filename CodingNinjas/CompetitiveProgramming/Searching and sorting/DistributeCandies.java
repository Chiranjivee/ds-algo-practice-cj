import java.util.*;

public class DistributeCandies {
	
	public static void main(String[] args) {
		// Write your code here
		Scanner sc = new Scanner(System.in);
      	int t = sc.nextInt();
      	for (int i = 0; i < t; i++) {
          	int boxes = sc.nextInt();
          	int students = sc.nextInt();
          	int [] candies = new int[boxes];
            int totalCandies = 0;
          	for (int j = 0; j < boxes; j++) {
                candies[j] = sc.nextInt();
              	totalCandies += candies[j];
            }
            
            Arrays.sort(candies);
            
          	if (totalCandies < students) {
              	System.out.println("0");
            }
          	System.out.println(binarySearch(candies, students));
        }
	}
  
  	public static int binarySearch(int [] array, int students) {
      	int start = 0;
      	int end = array.length - 1;
      	int lastAnswer = 0;
      	while (start <= end) {
			int mid = (start + end) / 2;
          	int tryCandies = array[mid];
	      	if (canGiveAllKCandies(array, tryCandies, students)) {
                start = mid + 1;
              	lastAnswer = tryCandies;
    	    } else {
        		end = mid - 1;
        	}
        }
      	return lastAnswer;
    }
  
  	public static boolean canGiveAllKCandies(int [] array, int tryCandies, int k) {
        if (k == 1) return true;
      	int n = array.length;
      	int studentsServed = 0;
      	for (int i = n - 1; i >= 0; i--) {
          	studentsServed += (array[i] / tryCandies); 
        }
      
      	if (studentsServed >= k) {
          	return true;
        } else {
          return false;
        }
    }
}