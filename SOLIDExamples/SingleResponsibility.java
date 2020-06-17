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
}
