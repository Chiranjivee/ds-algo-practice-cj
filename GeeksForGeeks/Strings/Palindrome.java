class Palindrome {
    public boolean isPalindrome(String str) {
        for (int i = 0; i  < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(n  - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
