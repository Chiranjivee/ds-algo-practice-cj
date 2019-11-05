import java.util.*;

public class LightUpBulbs {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long x = in.nextLong();
		long y = in.nextLong();

		String input = in.next();

		int count = 0;
		if (input.charAt(0) == '0')
			count++;
		for (int i = 1; i < input.length(); i++) {
			int prev = i - 1;
			if (input.charAt(prev) == '1' && input.charAt(i) == '0') {
				count++;
			}
		}

		if (count == 0) {
			System.out.println(0);
		} else {
			System.out.println(((count - 1) * Math.min(x, y)) + y);
		}
	}
}