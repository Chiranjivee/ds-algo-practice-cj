class FiniteStateMachine {
    public static void main(String[] args) {

        String evenState = "even";
        String oddState = "odd";

        String currentState = "even";

        String input = "001101010";
        for (int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if (c == '0') {
                if (currentState.equals(evenState)) {
                    currentState = oddState;
                } else {
                    currentState = evenState;
                }
            }
        }

        System.out.println(currentState);
    }
}