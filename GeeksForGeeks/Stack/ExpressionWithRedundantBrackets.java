class ExpressionWithRedundantBrackets {
    public boolean hasRedundancy(String exp) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == ')') {

                boolean flag = true;
                while (st.peek() != '(') {
                    char c = st.pop();
                    if (isOperator(c)) {
                        flag = false;
                    }
                    st.pop();
                }

                if (flag) return true;
                st.pop();

            } else st.push(exp.charAt(i));
        }

        return false;
    }
}
