class Solution {
    public String decodeString(String s) {
        if (s == null || s.equals("")) return "";
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        StringBuilder revHelper = new StringBuilder();

        Stack<String> st = new Stack<>();
        int number = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == "[".charAt(0)) {
                st.push(String.valueOf(number));
                number = 0;
                st.push("[");
                continue;
            }

            if (c == "]".charAt(0)) {
                while (st.peek() != "[") {
                    // keep popping from stack
                    revHelper.append(st.pop());
                    temp.append(revHelper.reverse());
                    revHelper.setLength(0);
                }
                temp.reverse();

                // pop the open bracket
                st.pop();
                String tempString = temp.toString();
                temp.setLength(0);
                int tempMultiplier = Integer.valueOf(st.pop());
                while (tempMultiplier-- > 0) {
                    if (st.isEmpty()) {
                        result.append(tempString);
                    } else {
                        temp.append(tempString);    
                    }
                }
                
                if (st.isEmpty()) {
                    number = 0;
                } else {
                    st.push(temp.toString());    
                }

                temp.setLength(0);
                continue;
            }
            
            if (Character.isDigit(c)) {
                number *= 10;
                number += c - '0';
                continue;
            }

            st.push(c+"");
        }

        while (!st.isEmpty()) {
            revHelper.append(st.pop());
            temp.append(revHelper.reverse());
            revHelper.setLength(0);
        }

        temp.reverse();
        result.append(temp);
        return result.toString();
    }
}
