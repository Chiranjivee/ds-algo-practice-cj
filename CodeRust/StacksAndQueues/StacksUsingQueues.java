import java.util.Queue;
import java.util.LinkedList;

class StackUsingQueues {

    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();
    int size = 0;

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Empty stack exception.");
        }

        // move all the elements to the queue2 except last element;
        while (queue1.size() != 1) {
            queue2.offer(queue1.poll());
        }
        int element = queue1.poll();
        size--;

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return element;
    }

    public void push(int element) {
        queue1.offer(element);
        size++;
    }

    public boolean isEmpty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {

        StackUsingQueues stack = new StackUsingQueues();
        stack.push(2);
        stack.push(3);
        int top = stack.pop();
        System.out.println(top);

    }
}
