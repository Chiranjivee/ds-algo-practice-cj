/**
 * 
 * 
 */
import java.util.*; 
  
class NewManConwaySequence {

    static int sequence(int n) {
        int f[] = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        f[2] = 1;

        int i;

        for (i = 3; i <= n; i++) {
            f[i] = f[f[i - 1]] + f[i - f[i - 1]];
        }

        return f[n];
    }

    public static void main(String[] args) {
         int n = 10;
         System.out.println(sequence(n));
    }
}
