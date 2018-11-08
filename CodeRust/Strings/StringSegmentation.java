import java.util.HashSet;

class StringSegmentation {

    public boolean canSegment(
        String input, HashSet<String> set, HashSet<String> solvedSet) {

        if (input == null || input.length() == 0) {
            return false;
        }
        for (int i = 0; i < input.length(); i++) {
            String firstWord = input.substring(0, i + 1);
            if (set.contains(firstWord)) {
                String secondWord = input.substring(i + 1);

                if (secondWord == null || 
                    secondWord.length() == 0 || 
                    set.contains(secondWord)) {
                        return true;
                } else {
                    if (!solvedSet.contains(secondWord)) {
                        if (canSegment(secondWord, set, solvedSet)) {
                            return true;
                        }
                        solvedSet.add(secondWord);
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> solvedSet = new HashSet<>();
        set.add("pie");
        set.add("peer");
        set.add("apple");
        set.add("peach");

        String input = "applepie";

        StringSegmentation stringSegmentation = new StringSegmentation();
        boolean result = stringSegmentation.canSegment(input, set, solvedSet);
        System.out.println("Can segment: '" + input + "' in segments: " + result);
    }
}