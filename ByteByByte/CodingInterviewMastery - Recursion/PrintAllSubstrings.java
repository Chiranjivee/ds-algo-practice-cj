class PrintAllSubstrings {

    /**
     * Time complexity - O(n ^ 2)
     * 
     * @param s
     */
    public static void printSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                System.out.println(s.substring(i, j));
            }
        }
    }

    public static void printSubstringsRecursive(String s) {
        if (s.length() == 0) return;
        printSubstringFirstFor(s, 0);
    }

    private static void printSubstringFirstFor(String s, int i) {
        if (i >= s.length()) {
            return;
        }

        printSubstringSecondFor(s, i, i + 1);
        printSubstringFirstFor(s, i + 1);
    }

    private static void printSubstringSecondFor(String s, int i, int j) {
        if (j > s.length()) {
            return;
        }

        System.out.println(s.substring(i, j));
        printSubstringSecondFor(s, i, j + 1);
    }

    public static void main(String[] args) {
        printSubstringsRecursive("abc");
    }
}