import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Iterator;

class SortIncreasingArray {
    public Integer[] sortIncreasingDecreasingArray(Integer [] input) {
        return merge(getSeparatedLists(Arrays.asList(input))).toArray(new Integer[input.length]);
    }

    public List<Integer> merge(List<List<Integer>> input) { 
        List<Iterator<Integer>> iterList = new ArrayList<>();
        for (List<Integer> list : input) {
            iterList.add(list.iterator());
        }

        PriorityQueue<PQEntry> queue = new PriorityQueue<>(input.size(), (a, b) -> a.value - b.value);
        for (int i = 0; i < input.size(); i++) {
            if (iterList.get(i).hasNext())
                queue.offer(
                    new PQEntry(
                        i, 
                        iterList.get(i).next()));
        }

        List<Integer> resultList = new ArrayList<>();
        while (!queue.isEmpty()) {
            PQEntry resultEntry = queue.poll();
            resultList.add(resultEntry.value);
            if (iterList.get(resultEntry.arrayId).hasNext())
                queue.add(
                    new PQEntry(
                        resultEntry.arrayId, 
                        iterList.get(resultEntry.arrayId).next()));
        }
        return resultList;
    }

    public List<List<Integer>> getSeparatedLists(List<Integer> input) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayType type = ArrayType.INCREASING;
        int startIdx = 0;
        for (int i = 1; i <= input.size(); i++) {
            if (i == input.size() ||
                input.get(i - 1) > input.get(i) && type == ArrayType.INCREASING ||
                input.get(i - 1) < input.get(i) && type == ArrayType.DECREASING) {
                    List<Integer> subList = input.subList(startIdx, i);
                    if (type == ArrayType.DECREASING) {
                        Collections.reverse(subList);
                    }
                    result.add(subList);
                    startIdx = i;
                    type = type == ArrayType.INCREASING ? ArrayType.DECREASING : ArrayType.INCREASING;
            }
        }
        return result;
    }

    public static void main(String[] args) {
       SortIncreasingArray incDec = new SortIncreasingArray();
       Integer [] sorted = incDec.sortIncreasingDecreasingArray(new Integer [] {57, 131, 493, 294, 221, 339, 418, 452, 442, 190 }); 
       System.out.println(Arrays.toString(sorted));
    }
}

enum ArrayType {
    INCREASING,
    DECREASING
}

class PQEntry {
    int arrayId;
    int value;

    public PQEntry(int arrayId, int value) {
        this.arrayId = arrayId;
        this.value = value;
    }
}
