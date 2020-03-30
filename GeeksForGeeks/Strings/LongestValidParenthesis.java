class LongestValidParenthesis {

    public int longestValidParenthesis(String s) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                stacck.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}