class NaivePatternMatching {
    public boolean match(String text, String pattern) {
        if (text == null || pattern == null) {
            return false;
        } 

        if (pattern.length() == 0) return true;
        // aa a
        for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
            int start = i;
            for (int j = 0; j < pattern.length(); j++) {
                if (text.charAt(start) == pattern.charAt(j)) {
                    if (j + 1 == pattern.length()) return true;
                    start++;
                } else {
                    break;
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {
        NaivePatternMatching matcher = new NaivePatternMatching();
        System.out.println("Find test in testing:" + matcher.match("testing", "test2"));
    }
}