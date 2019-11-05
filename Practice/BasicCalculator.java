public class Solution {
    public int evaluateExpression(String expression) {
        int currentSign = 1;
        int currentNumber = 0;
        int multiplier = 1;
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        if (expression==null){
            return  0;
        }
    
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                currentNumber += (multiplier) * Integer.parseInt(c + “”);
                multiplier *= 10;
            } else if (expression.charAt(i) == '+') {
                result += currentSign * currentNumber;
                currentNumber = 0;
                currentSign = 1;
            } else if (expression.charAt(i) == '+') {
                result += currentSign * currentNumber;
                currentNumber = 0;
                currentSign = -1;
            } else if (expression.charAt(i) == '+' {
                stack.push(currentNumber);
                stack.push(currentSign);
                currentNumber = 0;
                currentSign = 1;
            } else if (expression.charAt(i) == '+') {
                result += currentSign * currentNumber;
                result += stack.pop() * stack.pop();
                currentNumber = 0;
                currentSign = 1;
            }
        }
    
        return result;
    }
}
