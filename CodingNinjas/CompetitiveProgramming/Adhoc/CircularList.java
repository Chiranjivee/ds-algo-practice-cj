import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int i = in.nextInt();
			int p = in.nextInt();
			System.out.println((i + p) % 12);
		}
	}
}
