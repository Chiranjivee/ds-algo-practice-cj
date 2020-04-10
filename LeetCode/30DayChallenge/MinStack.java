class MinStack {

    Stack<StackNode> stack = new Stack<>();
    
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new StackNode(x, x));
            return;
        }
        
        int minValue = stack.peek().minValue;
        stack.push(new StackNode(x, Math.min(x, minValue)));
    }
    
    public void pop() {
        if (!stack.isEmpty()) stack.pop();
    }
    
    public int top() {
        return stack.peek().value;
    }
    
    public int getMin() {
        return stack.peek().minValue;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

class StackNode {
    int value;
    int minValue;
    
    public StackNode(int value, int minValue) {
        this.value = value;
        this.minValue = minValue;
    }
}
