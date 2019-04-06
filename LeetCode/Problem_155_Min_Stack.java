class MinStack {

    Stack<MinStackNode> st;
    
    /** initialize your data structure here. */
    public MinStack() {
        this.st = new Stack<>();  
    }
    
    public void push(int x) {
        int min = st.isEmpty() ? x : Math.min(x, st.peek().min);
        st.push(new MinStackNode(x, min));
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().x;
    }
    
    public int getMin() {
        return st.peek().min;
    }
}

class MinStackNode {
    int x;
    int min;
    
    public MinStackNode(int x, int min) {
        this.x = x;
        this.min = min;
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