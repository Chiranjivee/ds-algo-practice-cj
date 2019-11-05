class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            if (token.equals("+")) {
                int optionOne = stack.pop();
                int optionTwo = stack.pop();
                int res = optionOne + optionTwo;
                stack.push(res);
            } else if (token.equals("-")) {
                int optionOne = stack.pop();
                int optionTwo = stack.pop();
                int res = optionTwo - optionOne;
                stack.push(res);
            } else if (token.equals("*")) {
                int optionOne = stack.pop();
                int optionTwo = stack.pop();
                int res = optionOne * optionTwo;
                stack.push(res);
            } else if (token.equals("/")) {
                int optionOne = stack.pop();
                int optionTwo = stack.pop();
                int res = optionTwo / optionOne;
                stack.push(res);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
