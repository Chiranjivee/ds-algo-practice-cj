class ReverseWordsInSentence {

    public char[] reverseWords (char[] sentence) { // "This is";
        if (sentence == null || sentence.length == 0) {
            return sentence;
        }

        char[] reversedSentence = reverseSentence(sentence); //  "This is"; => "si sihT"

        int startWord = 0;
        int endWord = 0;
        for (int i = 0; i < reversedSentence.length; i++) {  // len = 6
            if (reversedSentence[i] == ' ') { // 2 true
                endWord = i - 1;
                reverseWordInArray(reversedSentence, startWord, endWord); // "si sihT" , 0, 1
                startWord = i + 1; // 2
                endWord = i + 1; // 2
            } else if (i == reversedSentence.length - 1) {
                endWord = i;
                System.out.println("Last word found: start: " + startWord + " End: " + endWord);
                System.out.println("Current: " + new String(reversedSentence));
                reverseWordInArray(reversedSentence, startWord, endWord);
            }
        }
        return sentence;
    }

    public char[] reverseSentence (char [] sentence) { //  "This is";
        for (int i = 0; i < sentence.length / 2; i++) { // i < 3
            swap(sentence, i, (sentence.length - 1) - i); // i = 3, 3
        }
        return sentence;
    }

    public char[] reverseWordInArray(char [] sentence, int wordStart, int wordEnd) { // "si sihT" , 0, 1
        if (wordEnd < 0 || wordStart < 0) {
            return sentence;
        }
        int mid = wordStart + ((wordEnd - wordStart)/ 2);
        for (int i = wordStart; i < mid + 1; i++) { // "si sihT" , 0, 1
            swap(sentence, i, wordEnd--);
        }
        return sentence;
    }

    public void swap(char[] sentence, int i, int j) {
        if ( i == j) {
            return ;
        }

        char temp = sentence[i];
        sentence[i] = sentence[j];
        sentence[j] = temp;
    }
    public static void main(String[] args) {
        ReverseWordsInSentence sol = new ReverseWordsInSentence();
        String input = "   This is a test string.   ";
        System.out.println("Input : " + input);
        System.out.println("After reversal: " +
            new String(sol.reverseWords(
                input.toCharArray())));
    }
}