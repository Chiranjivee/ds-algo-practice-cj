import java.util.Random;

class Divide {

    /**
     * The idea is to find larget power of 2 which is k such that
     * 2^k * y <= x
     * @param x
     * @param y
     * @return
     */
    public static long divide(long x, long y) {
        long result = 0;
        int power = 32;
        long yPower = y << power;
        while (x >= y) {
            while (yPower > x) {
                yPower >>>= 1;
                --power;
            }
            result += 1L << power;
            x -= yPower;
        }
        return result;
    }
    public static void main(String [] args) {
        System.out.println(divide(4, 2));
    }
}