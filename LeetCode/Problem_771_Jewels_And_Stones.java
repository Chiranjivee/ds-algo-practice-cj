import java.util.Set;
import java.util.HashSet;

class Solution {
    public static void main(String [] args) {
        String J = "aB";
        String S = "aaBBAACCD";
        System.out.println("Jewels Count: " + jewelsAndStones(J, S));
    }
    public static int jewelsAndStones(String J, String S) {
        if (J == null || J.equals("")) return 0;
        if (S == null || S.equals("")) return 0;
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            charSet.add(J.charAt(i));
        }
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (charSet.contains(S.charAt(i))) count++;
        }
        return count;
    }
}
