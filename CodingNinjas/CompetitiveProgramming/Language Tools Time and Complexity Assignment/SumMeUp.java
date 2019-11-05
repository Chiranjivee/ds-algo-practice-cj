import java.util.*;

public class SumMeUp {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			long n = in.nextLong();
			System.out.println(sumDigits(n));
		}
	}

	public static long sumDigits(long n) {
		long sum = 0;
		while (n > 0) {
			long digit = n % 10;
			sum += digit;
			n /= 10;
		}
		return sum;
	}
}
