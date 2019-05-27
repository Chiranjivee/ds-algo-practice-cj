class NaivePatternMatching {

    public static boolean match(String s, String pattern) {
        int n = s.length();
        int m = pattern.length();

        for (int i = 0; i <= (n - m); i++) {
            boolean isFound = true;
            for (int j = 0; j < m; j++) {
                if (s.charAt(i + j) != pattern.charAt(j)) {
                    isFound = false;
                    break;
                }
            }

            if (isFound) {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        boolean test = match("abcd", "cd");
        System.out.println(test);
    }
}
