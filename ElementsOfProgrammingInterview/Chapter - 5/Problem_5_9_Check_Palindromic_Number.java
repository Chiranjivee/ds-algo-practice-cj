class CheckPalindromeNumber {
    public static boolean isPalindrome(int number) {
        if (number < 0) return false;

        int numberOfDigits = (int) Math.floor((int) Math.log10(number)) + 1;
        int mask = (int) Math.pow(10, numberOfDigits - 1);

        for (int i = 0; i < (numberOfDigits / 2); ++i) {
            if (number / mask != number % 10) {
                return false;
            }

            number %= mask;
            number /= 10;
            mask /= 100;
        }

        return true;
    }
    public static void main(String[] args) {
        int [] input = { 1, 11, 121, 122, 123, 1001 };
        for (int x : input) {
            System.out.println(x + " is palindrome: " + isPalindrome(x));
        }        
    }
}