class Calculator {
    public AdditionResult add(Number one, Number two) {

        if (one.isInteger() && two.isInteger()) {
            // add logic.
        } else if (one.isDecimal() && two.isDecimal()) {
            // add logic.
        } else if (one.isBigInteger() && two.isBigInteger()) {
            // add logic
        } else {
            // error handlers.
        }
    }

    public SubtractResult subtract(Number one, Number two) {
        // subtract logic
        return (SubtractResult) this.add(one, two.negate());
    }
}

class Calculator {
    public CalculationResult computeBinaryExpression(
        Number one, 
        Number two, 
        OperationType op) {

        return operationType.operate(one, two);
    }

    public CalculationResult computeUnaryExpression(
        Number one, 
        OperationType op) {

        return operationType.operate(one);
    }
}

// Just a name change for the class and the 
// methods fall under one responsibility group
class FileNetworkIOGateway {

    public void uploadFile(File file, String url) {}

    public File downloadFile(String url) {}
}


class MyResponsibleClass {

    private DependencyOne dependencyOne;
    private DependencyTwo dependencyTwo;
    private DependencyThree dependencyThree;

    public void myResponsibleMethod(Argument argument) {

        Result1 resultFromFirstDependency = 
            dependencyOne.callingItsResponsibleMethodFor(argument);

        Result2 resultFromFirstDependency2 =
            dependencyTwo.callingItsResponsibleMethodFor(resultFromFirstDependency);

        Result3 resultFromFirstDependency3 =
            dependencyThree.callingItsResponsibleMethodFor(resultFromFirstDependency2);

        return resultFromFirstDependency3;
    }
}