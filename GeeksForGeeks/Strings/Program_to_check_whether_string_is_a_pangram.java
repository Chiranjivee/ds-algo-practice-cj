class Solution {
    public static void main(String[] args) {
        String input = "The quick brown for jumps right over the lazy dog.";
        boolean [] mark = new boolean[26];

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if ('A' <= currentChar && currentChar <= 'Z') {
                mark[currentChar - 'A'] = true;
            } else if ('a' <= currentChar && currentChar <= 'z') {
            	mark[currentChar - 'a'] = true;
            }
        }

	for (int j = 0; j < mark.length; j++) {
            if (!mark[j]) {
                System.out.println("Not a pangram:" + j);
		return;
            }
        }

	System.out.println("Is a pangram");
    }
}