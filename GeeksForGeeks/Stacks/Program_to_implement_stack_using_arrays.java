class Solution {
    class Stack {
        int [] arr;
        int top;
        int MAX_SIZE = 100;

        public Stack()
        {
            arr = new int[MAX_SIZE];
            tpp = -1;
        }

        public void push(int i) {
            if (top < MAX_SIZE - 1) {
                arr[++top] = i;
                return;
            }

            throw new Exception("Stack is full.");
        }

        public int peek() {
            return arr[top];
        }

        public int pop() {
            if (top == -1) throw new Exception("Stack is empty.");
            return arr[top--];
        }
    }
}
