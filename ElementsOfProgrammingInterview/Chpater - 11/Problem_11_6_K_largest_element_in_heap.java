import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

class KLargest {
    public List<Integer> kLargest(List<Integer> input, int k) {
        if (k <= 0) {
            return Collections.emptyList();
        }

        PriorityQueue<HeapEntry> queue = new PriorityQueue<>(k, (a, b) -> b.value - a.value);

        queue.offer(new HeapEntry(0, input.get(0)));
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int element = queue.peek().value;
            int index = queue.remove().index;
            result.add(index);
            int leftIdx = index * 2 + 1;
            if (leftIdx < input.size()) {
                queue.offer(new HeapEntry(leftIdx, input.get(leftIdx)));
            }
            int rightIdx = index * 2 + 2;
            if (rightIdx < input.size()) {
                queue.offer(new HeapEntry(rightIdx, input.get(rightIdx)));
            }
        }
        return result;
    }
}
class HeapEntry {
    int index;
    int value;
    public HeapEntry(int i, int v) {
        this.index = i;
        this.value = v;
    }
}