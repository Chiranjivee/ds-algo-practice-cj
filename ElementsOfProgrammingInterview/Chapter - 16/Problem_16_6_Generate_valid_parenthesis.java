import java.util.List;
import java.util.ArrayList;

class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        directedGenerateParenthesis(n, n, "", result);
        return result;
    }

    public void directedGenerateParenthesis(int leftRemaining, int rightRemaining, String prefix, List<String> result) {
        if (leftRemaining == 0 && rightRemaining == 0) {
            result.add(prefix);
            return;
        }

        if (leftRemaining > 0) {
            directedGenerateParenthesis(leftRemaining - 1, rightRemaining, prefix + "(", result);
        }
        if (leftRemaining < rightRemaining) {
            directedGenerateParenthesis(leftRemaining, rightRemaining - 1, prefix + ")", result);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis parenGenerator = new GenerateParenthesis();
        List<String> result = parenGenerator.generateParenthesis(3);
        for (String temp : result) {
            System.out.println(temp);
        }
    }

}