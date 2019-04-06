class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("C")) {
                sum -= stack.pop();
            } else if (ops[i].equals("+")) {
                int last = stack.pop();
                int secLast = stack.pop();
                stack.push(secLast);
                stack.push(last);
                stack.push(last + secLast);
                sum += last + secLast;
            } else if (ops[i].equals("D")) {
                sum += 2 * stack.peek();
                stack.push(2 * stack.peek());
            } else {
                sum += Integer.valueOf(ops[i]);
                stack.push(Integer.valueOf(ops[i]));
            }
        }
              
        return sum;
    }
}
