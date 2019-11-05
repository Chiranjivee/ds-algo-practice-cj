import java.util.PriorityQueue;

class StackWithHeap {
    int timestamp = 0;
    PriorityQueue<StackNode> maxHeap = new PriorityQueue<>(16, (a, b) -> b.rank - a.rank);
    
    void push(int data) {
        maxHeap.add(new StackNode(data, ++timestamp));
    }

    int pop() throws Exception {
        if (maxHeap.isEmpty()) throw new Exception("Stack is empty");
        return maxHeap.remove().data;
    }

    int peek() throws Exception {
        if (maxHeap.isEmpty()) throw new Exception("Stack is empty");
        return maxHeap.peek().data;
    }
}

class StackNode {
    int data;
    int rank;

    public StackNode(int data, int rank) {
        this.data = data;
        this.rank = rank;
    }
}