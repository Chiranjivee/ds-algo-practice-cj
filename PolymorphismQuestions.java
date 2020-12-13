import java.util.Map;

/**
 * Write a program to implement a mini calculator, which takes two numbers and one operator. "+" or "-"
 * 
 * Part - 1: Solve it without polymorphism using (if else)
 * Part - 2: Solve it with polymorphism.
 *
 * 
 * Part - 3: Add multiplication and division to first problem.
 * Part - 4: Add multiplication and division to second part of solution.
 * 
 * Part - 5: Observe the difference between the two approaches.
 */
public class PolymorphismQuestions {
(

    public int solveWithoutPolymorphism(int x, int y, String operator) {

        if ("+".equals(operator)) {
            return x + y;
        } else if ("-".equals(operator)) {
            return x - y;
        } else {
            System.out.println("Operation not permitted.");
            return 0;
        }
    }

    public int solveWithPolymorphism(int x, int y, String operatorSymbol) {

        Operator operator = OperatorFactory.getOperatorFromSymbol(operator);

        int answer2 = operator.operate(x, y);
        return answer2;
    }

    public static void main(String [] args) {

        // initialize inputs
        int x = 2;
        int y = 4;
        String operator = "+";

        PolymorphismQuestions pq = new PolymorphismQuestions();

        // start of part - 1 solution.
        int answer = pq.solveWithoutPolymorphism(x, y, operator);
        System.out.println("Answer: " + answer);
        // end of part - 1 solution

        // start of part - 2 solution.
        int answer2 = pq.solveWithPolymorphism(x, y, operatorSymbol);
        System.out.println("Answer: " + answer2);
        // end of part - 2 solution.
    }
}

abstract class Operator {

    abstract int operate(int x, int y);
}

class PlusOperator extends Operator {

    @Override
    public int operate(int x, int y) {
        return x + y;
    }
}

class MinusOperator extends Operator {

    @Override
    public int operate(int x, int y) {
        return x - y;
    }
}

class OperatorFactory {

    static Map<String, Operator> operatorMap;

    public void initialize() {
        operatorMap = new HashMap<>();
        operatorMap.put("+", new PlusOperator());
        operatorMap.put("-", new MinusOperator());
    }

    public static Operator getOperatorFromSymbol(String operator) {
        if (operatorMap == null) {
            initialize();
        }



        if (operatorMap.containsKey(operator)) {
            return operatorMap.get(operator):
        } else {
            throw new IllegalArgumentException("Operation not supported. Invalid symbol: " + operator);
        }
    }
}
