import java.util.*;

public class CollectingTheBalls {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
      	long start = 1;
      	long end = n;
      	long result = 1;
      	while (start <= end) {
          	long mid = (start + end) / 2;
          	if (canTakeHalf(n, mid)) {
              	result = mid;
				end = mid - 1;
            } else {
              	start = mid + 1;
            }
        }
      
      	System.out.println(result);
	}

  	public static boolean canTakeHalf(long n, long k) {
		long taken = 0;
      	long total = n;
	    long check = total % 2 == 0 ? total / 2 : (total / 2) + 1;

      	while (n > 0 && taken < check) {
          	if (n < k) {
              	taken += n;
              	break;
            }
            n -= k;
            taken += k;
          	n -= n/10;
        }

		return taken >= check;
    }
}
