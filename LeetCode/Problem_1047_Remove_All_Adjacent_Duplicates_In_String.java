class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (st.isEmpty()) {
                st.push(S.charAt(i));
                continue;
            }
            
            char currentChar = S.charAt(i);
            if (st.peek() == currentChar) {
                st.pop();
            } else {
                st.push(currentChar);
            }
        }
        
        StringBuilder builder = new StringBuilder();
        while (!st.isEmpty()) {
            builder.append(st.pop());
        }

        builder.reverse();
        return builder.toString();
    }
}
