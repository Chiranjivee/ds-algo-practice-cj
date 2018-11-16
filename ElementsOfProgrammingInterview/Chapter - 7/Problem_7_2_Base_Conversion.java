class BaseConversion {
    public static String convertBase(String numAsString, int base1, int base2) {
        int numAsInt = convertStringFromGivenBaseToDecimal(numAsString, base1);
        return convertDecimalToGivenBase(numAsInt, base2);
    }

    public static int convertStringFromGivenBaseToDecimal(String numAsString, int base) {
        if (numAsString == null || numAsString.length() == 0) {
            return 0;
        }

        int result = 0;
        boolean isNegative = numAsString.charAt(0) == '-';
        for (int i = isNegative ? 1 : 0; i < numAsString.length(); i++) {
            final int digit = Character.isDigit(numAsString.charAt(i)) ? numAsString.charAt(i) - '0': numAsString.charAt(i) - 'A' + 10 ;
            if (digit < 0 || digit > 15) {
                throw new IllegalArgumentException("Input string is not a valid number");
            }
            result *= base;
            result += digit;
        }
        return isNegative ? -result : result;
    }

    public static String convertDecimalToGivenBase(int number, int base) {
        StringBuilder result = new StringBuilder();
        boolean isNegative = number < 0;
        while (number != 0) {
            result.append(Math.abs(number) % base);
            number /= base;
        }
        if (isNegative) result.append('-');
        return result.reverse().toString();
    }

    public static void main(String[] args) throws IllegalArgumentException {
        System.out.println(convertBase("4", 10, 2));
    }    
}
