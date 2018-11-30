import java.util.Random;

class Random7From5 {
    int random5() {
        Random random = new Random();
        return random.nextInt(5);
    }

    int random7From5() {
        while (true) {
            int num = 2 * random5(); // this gives 0 2 4 6 8
            int num2 = random5(); // this gives 0 1 2 3 4
            if (num2 != 4) {
                num2 = num2 % 2; // this give 1 or 0 with equal probability
                num = num + num2;
                if (num < 7) {
                    return num;
                }
            }
        }
    }


    public static void main(String[] args) {
        Random7From5 test = new Random7From5();
        System.out.println(
            test.random7From5() + " " +
            test.random7From5() + " " +
            test.random7From5() + " " +
            test.random7From5() + " " +
            test.random7From5() + " " +
            test.random7From5() + " " +
            test.random7From5() + " ");

    }
}
