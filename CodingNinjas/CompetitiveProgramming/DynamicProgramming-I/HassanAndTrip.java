import java.util.Scanner;

public class HassanAndTrip {
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        City[] cities = new City[n + 1];
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int f = sc.nextInt();
            cities[i] = new City(x, y, f);
        }
        sc.close();

        double[] dp = new double[n + 1];
        dp[1] = cities[1].hap;
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MIN_VALUE;
            for (int j = 1; j < i; j++)
                dp[i] = Math.max(dp[i], dp[j] + cities[i].hap - City.getDistanceBetween(cities[i], cities[j]));

        }

        System.out.println(String.format("%.6f", dp[n]));
    }
}

class City {
    int x;
    int y;
    int hap;

    public City(int x, int y, int f) {
        this.x = x;
        this.y = y;
        this.hap = f;
    }

    public static double getDistanceBetween(City x, City y) {
        return (Math.sqrt((double) (x.x - y.x) * (x.x - y.x) + (double) (x.y - y.y) * (x.y - y.y)));
    }
}
