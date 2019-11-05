import java.util.PriorityQueue;
import java.util.Iterator;

class MedianOnlineData {
    public int median(Iterator<Integer> elements) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(); // larger half
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(); // smaller half
        while (elements.hasNext()) {
            Integer current = elements.next();
            if (minQueue.isEmpty()) {
                minQueue.offer(current);
            } else {
                if (current >= minQueue.peek()) {
                    minQueue.add(current);
                } else {
                    maxQueue.add(current);
                }
            }
            
            if (minQueue.size() > maxQueue.size() + 1) {
                maxQueue.add(minQueue.remove());
            } else if (maxQueue.size() > minQueue.size()) {
                minQueue.add(maxQueue.remove());
            }
        }
        return (maxQueue.size() == minQueue.size()) ? 
            (int) 0.5 * (maxQueue.peek() + minQueue.peek()) : 
            minQueue.peek();
    }
}