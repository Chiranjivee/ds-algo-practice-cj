import java.util.Stack;

class SortStack {
    Stack<Integer> sortStack(Stack<Integer> st) {
        if (st == null || st.isEmpty()) {
            return st;
        }
        // temp = 
        // 
        // 3 2 1
        Stack<Integer> newStack = new Stack<Integer>();
        newStack.push(st.pop());

        while (!st.isEmpty()) {
            Integer temp = st.pop();
            while (!newStack.isEmpty() && temp > newStack.peek()) {
                st.push(newStack.pop());
            }

            newStack.push(temp);
        }
        return newStack;
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(2);
        st.push(3);
        st.push(1);

        SortStack sortStack = new SortStack();
        Stack<Integer> result = sortStack.sortStack(st);
        System.out.println("Result size: " + result.size());
        while (!result.isEmpty()) {
            System.out.println(result.pop());
        }
    }
}