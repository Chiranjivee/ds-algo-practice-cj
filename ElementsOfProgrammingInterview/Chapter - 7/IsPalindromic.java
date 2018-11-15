class IsPalindrome {
    public static boolean isStringPalindrome(String input) {
        if (input == null) return false;
        if (input == "") return true;

        for (int i = 0, j = input.length() - 1; i < input.length() / 2 ; i++, j--) {
            if (input.charAt(i) != input.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println("Is test palindrome: " + isStringPalindrome("test"));
        System.out.println("Is pap palindrome: " + isStringPalindrome("pap"));
    }
}
