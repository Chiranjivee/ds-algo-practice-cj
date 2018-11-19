import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Iterator;

class MergeSortedArrays {

    public List<Integer> merge(List<List<Integer>> input) { 
        List<Iterator<Integer>> iterList = new ArrayList<>();
        for (List<Integer> list : input) {
            iterList.add(list.iterator());
        }
        PriorityQueue<PQEntry> queue = new PriorityQueue<>(input.size(), (a, b) -> a.value - b.value);
        for (int i = 0; i < input.size(); i++) {
            if (iterList.get(i).hasNext())
                queue.offer(new PQEntry(i, iterList.get(i).next()));
        }
        List<Integer> resultList = new ArrayList<>();
        while (!queue.isEmpty()) {
            PQEntry resultEntry = queue.poll();
            resultList.add(resultEntry.value);
            if (iterList.get(resultEntry.arrayId).hasNext())
                queue.add(new PQEntry(resultEntry.arrayId, iterList.get(resultEntry.arrayId).next()));
        }
        return resultList;
    }
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(5, 6, 7);
        List<Integer> list3 = Arrays.asList(8, 9, 10);
        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        MergeSortedArrays sortedArrays = new MergeSortedArrays();
        System.out.println("After merge:");
        for (Integer i : sortedArrays.merge(list)) {
            System.out.print(i + " ");
        }
    }
}

class PQEntry {
    int arrayId;
    int value;

    public PQEntry(int arrayId, int value) {
        this.arrayId = arrayId;
        this.value = value;
    }
}