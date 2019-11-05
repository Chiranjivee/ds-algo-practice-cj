import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class GeneratePermutations {

    public static void generatePermutations(List<Integer> input) {
        List<List<Integer>> result = new ArrayList<>();
        generatePermutationsUtil(0, input, result);
        for (List<Integer> temp : result) {
            System.out.println(temp);
        }
    }

    public static void generatePermutationsUtil(
        int i,
        List<Integer> input, List<List<Integer>> result) {
        if (i == input.size() - 1) {
            result.add(new ArrayList<>(input));
            return;
        }

        for (int j = i; j < input.size(); j++) {
            Collections.swap(input, i, j);
            generatePermutationsUtil(i + 1, input, result);
            Collections.swap(input, i, j);
        }
    }


    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        generatePermutations(input);
    }
}