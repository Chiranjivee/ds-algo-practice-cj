import java.util.PriorityQueue;

class PriorityQueueImpl {

    public static void main(String[] args) {
        PriorityQueue<Integer> numbers = new PriorityQueue<>(2, (a, b) -> a - b);
        numbers.add(200);
        numbers.add(100);
        numbers.add(400);
        numbers.add(50);
        while (!numbers.isEmpty()) {
            System.out.println("Number: " + numbers.poll());
        }
    }
}