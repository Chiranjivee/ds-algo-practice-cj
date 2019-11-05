import java.util.HashSet;

/**
 * Given a string remove duplicate characters.
 * eg. aabbccddee -> abcde
 */
class RemoveDuplicates {
    public String removeDuplicates(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }

        StringBuilder builder = new StringBuilder();
        HashSet<Character> charSet = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!charSet.contains(c)) {
                charSet.add(c);
                builder.append(c);
            }
        }

        return builder.toString();
    }
    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        String input = "testinput";
        System.out.println("Input: " + input);
        System.out.println("After removing dups: " +
            removeDuplicates.removeDuplicates(input));
    }
}