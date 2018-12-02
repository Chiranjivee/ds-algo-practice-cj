import java.util.List;
import java.util.ArrayList;

class PowerSet {

    public static void set(List<Integer> remaining, List<Integer> result) {
        if (remaining.size() == 0) {
            System.out.println(result);
            return;
        }

        int x = remaining.remove(0);
        result.add(x);
        set(new ArrayList<>(remaining), result);
        
        result.remove(result.size() - 1);
        set(new ArrayList<>(remaining), result);
    }
    public static void main(String[] args) {
        List<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(3);
        set(test, new ArrayList<>());
    }
}
