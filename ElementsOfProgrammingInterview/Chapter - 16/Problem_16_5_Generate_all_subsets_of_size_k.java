import java.util.List;
import java.util.ArrayList;

class GenerateSubsetsOfSizeK {
    public List<List<Integer>> generateKSizeSubsets(List<Integer> input, int k) {
        List<List<Integer>> result = new ArrayList<>();
        directedCombinations(input, k, new ArrayList<>(), 0, result);
        return result;
    }

    // 1 2 3 4
    public void directedCombinations(
                    List<Integer> input,
                    int k,
                    List<Integer> partialCombination, 
                    int offset, 
                    List<List<Integer>> result) {
        if (partialCombination.size() == k) {
            result.add(new ArrayList<>(partialCombination));
            return;
        }

        int numRemaining = k - partialCombination.size();
        for (int i = offset; i < input.size() && numRemaining <= input.size() - i + 1; i++) {
            partialCombination.add(input.get(i));
            directedCombinations(input, k, partialCombination, i + 1, result);
            partialCombination.remove(partialCombination.size() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateSubsetsOfSizeK subsetGen = new GenerateSubsetsOfSizeK();
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        List<List<Integer>> result = subsetGen.generateKSizeSubsets(input, 2);
        for (List<Integer> temp : result) {
            System.out.println(temp);
        }
    }
}