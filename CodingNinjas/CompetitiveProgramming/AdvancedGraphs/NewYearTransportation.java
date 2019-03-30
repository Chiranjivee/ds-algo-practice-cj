import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int des = sc.nextInt();
        int [] portals = new int[n + 1];
        for (int i = 1; i < n; i++) {
            portals[i] = sc.nextInt() + i;
        }

        System.out.println(Arrays.binarySearch(portals, des) < 0 ? "NO" : "YES");
	}
}
