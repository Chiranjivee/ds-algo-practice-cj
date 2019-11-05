import java.util.Random;

class GenerateRandomNumber {
    public static int getRandomZeroOrOne() {
        Random random = new Random();
        return random.nextInt(2);
    }
    
    public static int generateRandomNumber(int lowerBound, int upperBound) {
        int numbersOfOutcomes = upperBound - lowerBound + 1;
        int result = 0;
        do {
            result = 0;
            for (int i = 0; (1 << i) < numbersOfOutcomes; i++) {
                result = (result << 1) | getRandomZeroOrOne();
            }
        } while (result >= numbersOfOutcomes);
        return result + lowerBound;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++)
            System.out.println("Random between 1 & 6:" + generateRandomNumber(1, 6));
    }
}