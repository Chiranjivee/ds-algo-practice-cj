class InfixToPostFix {

    static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }

        return -1;
    }

    public String convertInfixToPostfix(String input) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
        
            if (c == '(') {
                stack.push(c);
            }

            if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }

                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "Invalid Expression";
                } else {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
                    if (stack.peek('(')) {
                        return "Invalid string";
                    }

                    result.append(stack.pop());
                }

                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
}
