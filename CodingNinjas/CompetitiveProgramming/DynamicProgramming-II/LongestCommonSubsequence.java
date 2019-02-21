class LongestCommonSubsequence {
    public static void main(String[] args){ 
        String s1 = "Tasty";
        String s2 = "1234";

        System.out.println(lcs(s1, s2));
    }

    public static int lcs(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty()) {
            return 0;
        }

        if (s1.charAt(0) == s2.charAt(0)) {
            return 1 + lcs(s1.substring(1), s2.substring(1));
        } else {
            int option1 = lcs(s1.substring(1), s2);
            int option2 = lcs(s1, s2.substring(1));

            return Math.max(option1, option2);
        }
    }
}