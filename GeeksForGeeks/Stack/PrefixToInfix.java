class Solution {

    String preToInfix(char[] pre_exp) {
        Stack<String> s = new Stack<>();
    
        // length of expression 
        int length = pre_exp.length;
    
        // reading from right to left 
        for (int i = length - 1; i >= 0; i--) {
    
            // check if symbol is operator 
            if (isOperator(pre_exp[i])) {
    
                // pop two operands from stack 
                String op1 = s.top();
                s.pop();
                String op2 = s.top();
                s.pop();
    
                // concat the operands and operator 
                String temp = "(" + op1 + pre_exp[i] + op2 + ")";
    
                // Push String temp back to stack 
                s.push(temp);
            }
    
            // if symbol is an operand 
            else {
    
                // push the operand to the stack 
                s.push(new String(pre_exp[i]));
            }
        }
    
        // Stack now contains the Infix expression 
        return s.top();
    }
}
