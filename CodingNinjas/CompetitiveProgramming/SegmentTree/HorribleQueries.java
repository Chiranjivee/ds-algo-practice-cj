import java.util.Scanner;
import java.util.Arrays;

public class HorribleQueries {
    public static void main(String[] args) {
        // Write your code here
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int c = in.nextInt();

            long[] tree = new long[4 * n];
            long[] lazy = new long[4 * n];

            while (c-- > 0) {
                int type = in.nextInt();
                if (type == 0) {
                    int p = in.nextInt();
                    int q = in.nextInt();
                    int v = in.nextInt();
                    update(tree, lazy, 0, n, p, q, v, 1);
                } else {
                    int p = in.nextInt();
                    int q = in.nextInt();
                    System.out.println(query(tree, lazy, 0, n, p, q, 1));
                }
            }
        }

        in.close();
    }

    public static void update(long[] tree, long[] lazy, int low, int high, int startR, int endR, long element,
            int currentPosition) {
        if (low > high) {
            return;
        }

        if (lazy[currentPosition] != 0) {
            tree[currentPosition] += (lazy[currentPosition] * (high - low + 1));

            if (low != high) {
                lazy[currentPosition * 2] += lazy[currentPosition];
                lazy[(2 * currentPosition) + 1] += lazy[currentPosition];
            }

            lazy[currentPosition] = 0;
        }

        // No overlap
        if (startR > high || endR < low) {
            return;
        }

        // complete overlap
        if (startR <= low && high <= endR) {
            tree[currentPosition] += (element * (high - low + 1));
            if (low != high) {
                lazy[2 * currentPosition] += element;
                lazy[(2 * currentPosition) + 1] += element;
            }
            return;
        }

        int mid = (low + high) / 2;
        update(tree, lazy, low, mid, startR, endR, element, currentPosition * 2);
        update(tree, lazy, mid + 1, high, startR, endR, element, (currentPosition * 2) + 1);

        tree[currentPosition] = tree[2 * currentPosition] + tree[2 * currentPosition + 1];
    }

    public static long query(long[] tree, long[] lazy, int low, int high, int startR, int endR, int currentPosition) {
        if (lazy[currentPosition] != 0) {
            tree[currentPosition] += (lazy[currentPosition] * (high - low + 1));
            if (low != high) {
                lazy[currentPosition * 2] += lazy[currentPosition];
                lazy[(currentPosition * 2) + 1] += lazy[currentPosition];
            }
            lazy[currentPosition] = 0;
        }

        // fully outside
        if (startR > high || endR < low) {
            return 0;
        }

        // fully overlap
        if (startR <= low && endR >= high) {
            return tree[currentPosition];
        }

        int mid = (low + high) / 2;
        long option1 = query(tree, lazy, low, mid, startR, endR, currentPosition * 2);
        long option2 = query(tree, lazy, mid + 1, high, startR, endR, (currentPosition * 2) + 1);
        return option1 + option2;
    }
}
