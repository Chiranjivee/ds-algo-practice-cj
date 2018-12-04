import java.util.List;
import java.util.ArrayList;

class PowerSet {

    public static void set(
        List<Integer> remaining, 
        int toBeSelected,
        List<Integer> result) {
        if (toBeSelected == remaining.size()) {
            System.out.println(new ArrayList<>(result));
            return;
        }

        result.add(remaining.get(toBeSelected));
        set(remaining, toBeSelected + 1, result);

        result.remove(result.size() - 1);
        set(remaining, toBeSelected + 1, result);
    }

    public static void main(String[] args) {
        List<Integer> test = new ArrayList<>();

        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);

        set(test, 0, new ArrayList<>());
    }
}
