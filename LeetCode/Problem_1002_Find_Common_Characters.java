class Solution {
    public List<String> commonChars(String[] A) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        List<String> output = new ArrayList<>();

        // For every char find the minium number of times it is 
        // coming in all the strings
        for (char c : alphabet) {
            int maxOccurance = Integer.MAX_VALUE;
            for (String s : A) {
                int count = 0;
                for (int j = 0; j < s.length(); j++)
                    if (s.charAt(j) == c)
                        count++;

                maxOccurance = Math.min(maxOccurance, count);
            }

            for (int z = 0; z < maxOccurance; z++) {
                output.add(String.valueOf(c));
            }
        }

        return output;
    }
}
