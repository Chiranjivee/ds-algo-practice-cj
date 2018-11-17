class PalindromeSubStrings {

    public int findPalindromeInSubstring(String input, int i, int j) {
        int count = 0;
        if (input == null || input.equals("")) {
            return count;
        }
        while (i >=0 && j < input.length()) {
            if (input.charAt(i) != input.charAt(j)) {
                break;
            }

            count++;
            System.out.println(input.substring(i, j + 1));
            i--;
            j++;
        }
        return count;
    }

    public int findAllPalindromeSubstring(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            count += findPalindromeInSubstring(input, i - 1, i + 1);
            count += findPalindromeInSubstring(input, i, i + 1);
        }

        return count;
    }
    public static void main(String[] args) {
        String input = "aabbbcc";
        PalindromeSubStrings solution = new PalindromeSubStrings();
        System.out.println(solution.findAllPalindromeSubstring(input));
    }
}