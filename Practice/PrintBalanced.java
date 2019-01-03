import java.util.List;
import java.util.ArrayList;

class PrintBalanced {

    public List<String> balancedParen(int n) {
        List<String> result = new ArrayList<>();
        getBalanced(n, n, "", result);
        return result;
    }

    public void getBalanced(
    int lR, int rR, String current, List<String> balanced) {
        if (lR == 0 && rR == 0) {
            balanced.add(current);
            return;
        }

        if (lR > 0) {
            getBalanced(lR - 1, rR, current + "(", balanced);
        } if (lR < rR) {
            getBalanced(lR, rR - 1, current + ")", balanced);
        }
    }
    public static void main(String[] args) {
        PrintBalanced printBalanced = new PrintBalanced();
        List<String> result = printBalanced.balancedParen(10);
        int i = 0;
        for (String temp : result) {
            System.out.println(++i + ": " + temp);
        }
    }
}

