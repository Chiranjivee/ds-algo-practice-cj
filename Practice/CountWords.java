import java.util.Stack;

class CountWords {
    public int countWords(String sentence) {
        if (sentence == null || sentence.length() == 0) {
            return 0;
        }

        int startWord = -1;
        int endWord = -1;
        boolean betweenToken = false;
        boolean betweenQuotes = false;
        Stack<Character> st = new Stack<>();
        int count = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char temp = sentence.charAt(i);
            if (startWord == -1 && endWord == -1 && temp == ' ') {
                continue;
            } else if (startWord == -1 && endWord == -1 && temp != ' ') {
                startWord = i;
                endWord = i;
                betweenToken = true;
                if (temp == '"' && !betweenQuotes) {
                    st.push(temp);
                    betweenQuotes = true;
                    betweenToken = true;
                } else if (temp == '"' && betweenQuotes) {
                    count++;
                    st.removeAllElements();
                    betweenQuotes = false;
                    betweenToken = false;
                    System.out.println(sentence.substring(startWord, endWord + 1));
                    startWord = -1;
                    endWord = -1;
                }
                
            } else if (startWord >= 0 && endWord >= 0 && temp == ' ' && betweenToken) {
                if (betweenQuotes) {
                    continue;
                }
                count++;
                startWord = -1;
                endWord = -1;
                betweenToken = false;
            } else if (startWord >= 0 && endWord >= 0 && temp != ' ' && !betweenToken) {
                startWord = i;
                endWord = i;
            }
        }
        
        if (betweenQuotes && !st.isEmpty()) {
            if (st.size() == 1) count++;
            while (!st.isEmpty()) {
                if (st.size() == 2) {
                    if (st.peek()  == ' ') {
                        count++;
                        st.pop(); st.pop();
                    };
                }
                char c = st.pop();
                if (c == ' ') count++;
            }
        } 

		if (betweenToken) count++;
		return count;
    }

    public static void main(String[] args) {
		CountWords wordCounter = new CountWords();
		System.out.println("Counting words:");
		System.out.println(wordCounter.countWords("    test    \"2 1234\" test tes @235"));
    }
}