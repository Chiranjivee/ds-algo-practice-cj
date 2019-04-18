class Solution {
    public String removeOuterParentheses(String S) {
        Set<Integer> ignore = new HashSet<>();
        
        Stack<Integer> st = new Stack<>();
        
        
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (st.isEmpty() || c == '(') {
                st.push(i);
                System.out.println("Pushing:" + i);
                continue;
            }
            
            if (st.size() == 1 && c == ')') {
                ignore.add(i);
                ignore.add(st.pop());
                System.out.println("Found");
                continue;
            }
            
            if (!st.isEmpty() && S.charAt(st.peek()) == '(' && c == ')') {
                System.out.println("Popping:");
                st.pop();
            }
        }
        
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (ignore.contains(i)) {
                continue;
            }
            builder.append(S.charAt(i));
        }
        
        return builder.toString();
    }
}
