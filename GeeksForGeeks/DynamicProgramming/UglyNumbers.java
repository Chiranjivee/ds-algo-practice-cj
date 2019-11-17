import java.util.Arrays;

public class UglyNumbers {

    // next ugly is a number from candidates 2 * prev_ugly or 3 * prev_ugly or 5 * prev_ugly
    public int[] getUglyNumbers(int n) {
        int [] ugly = new int [n];
        ugly[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        int n2 = ugly[i2] * 2;
        int n3 = ugly[i3] * 3;
        int n5 = ugly[i5] * 5;

        for (int i = 1; i < n; i++) {
            ugly[i] = Math.min(n2, Math.min(n3, n5));
            if (ugly[i] == n2) n2 = ugly[++i2] * 2;
            if (ugly[i] == n3) n3 = ugly[++i3] * 3;
            if (ugly[i] == n5) n5 = ugly[++i5] * 5;
        }

        return ugly;
    }

    public static void main(String[] args) {
        UglyNumbers uglyNumbers = new UglyNumbers();
        System.out.println(Arrays.toString(uglyNumbers.getUglyNumbers(15)));
    }
}