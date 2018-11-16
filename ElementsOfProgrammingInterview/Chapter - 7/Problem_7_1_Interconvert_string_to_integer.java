class StringToInt {
    public static int stringToInt(String s) throws IllegalArgumentException {
        int result = 0;
        for (int i = s.charAt(0) == '-' ? 1 : 0 ; i < s.length(); i++) {
            final int digit = s.charAt(i) - '0';
            if (digit < 0 || digit > 9) {
                throw new IllegalArgumentException("Can't convert input string: " + s + " to an integer");
            }
            result *= 10;
            result += digit;
        }
        return s.charAt(0) == '-' ? -result : result;
    }
    public static String intToString(int x) {
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x *= -1;
        }

        StringBuilder result = new StringBuilder();
        while (x >= 0) {
            result.append(x % 10);
            x /= 10;
            if (x == 0) break;
        }

        if (isNegative) result.append("-");
        return result.reverse().toString();
    }

    public static void main(String [] args) throws IllegalArgumentException {
        System.out.println(intToString(-102));
        System.out.println(intToString(0));
        System.out.println(intToString(10));
        System.out.println(intToString(99));
        System.out.println(intToString(0));
        System.out.println(intToString(-12));

        System.out.println();

        System.out.println(stringToInt("12"));
        System.out.println(stringToInt("123"));
        System.out.println(stringToInt("-12"));
        System.out.println(stringToInt("908"));
        System.out.println(stringToInt("abcd"));
    }
}