import java.util.List;
import java.util.ArrayList;

class InterleavingStrings {

    public static List<String> interleave(String s1, String s2) {
        List<String> result = new ArrayList<>();
        interleaveUtil(s1, s2, new StringBuilder(), 0, 0, result);
        return result;
    }

    public static void interleaveUtil(
        String s1, 
        String s2, 
        StringBuilder path, 
        int i, 
        int j,
        List<String> result) {
        
        if (i == s1.length() && j == s2.length()) {
            result.add(path.toString());
            return;
        }

        if (i < s1.length()) {
            path.append(s1.charAt(i));
            interleaveUtil(s1, s2, path, i + 1, j, result);
            path.setLength(path.length() - 1);
        }

        if (j < s2.length()) {
            path.append(s2.charAt(j));
            interleaveUtil(s1, s2, path, i, j + 1, result);
            path.setLength(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> result = interleave("ab", "cd");
        for (String temp : result) {
            System.out.println(temp);
        }
    }
}
