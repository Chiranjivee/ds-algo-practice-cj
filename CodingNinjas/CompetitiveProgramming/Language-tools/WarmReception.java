import java.util.Scanner;

public class WarmReception {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
      	int n = sc.nextInt();
      	int start[] = new int[n];
      	int end[] = new int[n];
      	for (int i = 0; i < n; i++) {
          	start[i] = sc.nextInt();
        }
      
      	for (int j = 0; j < n; j++) {
          	end[j] = sc.nextInt();
        }
      
     	int seats = 0;
        int maxSeats = 0;
      	for (int i = 0; i < 2360; i++) {
          	
          	for (int j = 0; j < n; j++) {
              	if (i >= start[j] && i <= end[j]) {
                  	seats++;
                }
              	if (maxSeats < seats) {
                  	maxSeats = seats;
                }
            }
          	seats = 0;
        }
    
      	System.out.println(maxSeats);
    }
}
