import java.util.List;
import java.util.ArrayList;

class GeneratePowerSet {

    public static List<List<Integer>> generatePowerSet(List<Integer> inputSet) {
        List<List<Integer>> result = new ArrayList<>();
        directPowerSet(inputSet, 0, new ArrayList<>(), result);
        return result;
    }

    public static void directPowerSet(List<Integer> inputSet, int toBeSelected, List<Integer> selectedSoFar, List<List<Integer>> result) {
        if (toBeSelected == inputSet.size()) {
            result.add(new ArrayList<>(selectedSoFar));
            return;
        }

        selectedSoFar.add(inputSet.get(toBeSelected));
        directPowerSet(inputSet, toBeSelected + 1, selectedSoFar, result);
        selectedSoFar.remove(selectedSoFar.size() - 1);
        directPowerSet(inputSet, toBeSelected + 1, selectedSoFar, result);
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        List<List<Integer>> powerSet = new ArrayList<>();
        powerSet = generatePowerSet(input);
        for (List<Integer> set: powerSet) {
            System.out.println("Set: " + set);
        }
    }
}