class Solution {
    // Convert prefix to Postfix expression 
    static String preToPost(String pre_exp) {

        Stack<String> s = new Stack<String> ();

        // length of expression 
        int length = pre_exp.length();

        // reading from right to left 
        for (int i = length - 1; i >= 0; i--) {

            // check if symbol is operator 
            if (isOperator(pre_exp.charAt(i))) {

                // pop two operands from stack 
                String op1 = s.peek();
                s.pop();
                String op2 = s.peek();
                s.pop();

                // concat the operands and operator 
                String temp = op1 + op2 + pre_exp.charAt(i);

                // Push String temp back to stack 
                s.push(temp);
            }

            // if symbol is an operand 
            else {
                // push the operand to the stack 
                s.push(pre_exp.charAt(i) + "");
            }
        }

        // stack contains only the Postfix expression 
        return s.peek();
    }
}
