class Solution {
    public static void main(String[] args) {
        String [] input = {"((a)", "(a))", "(((abc))((d)))))" , ""};
        String [] exOp = {"-10a1", "0a1-1", "000abc1100d111-1-1", ""};

        Solution sol = new Solution();
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input String: " + input[i] + ", Expected Result:" + exOp[i] + " Actual Result: " + sol.markUnmatchedParenthesis(input[i]));
        }
    }
    
    public String markUnmatchedParenthesis(String input) {
        char [] inputArr = input.toCharArray();
        int [] stack = new int [input.length()];
        int stackTop = -1;

        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] == '(') {
                stackTop++;
                stack[stackTop] = i;
                inputArr[i] = '0';
            }
            else if (inputArr[i] == ')') {
                if (stackTop == -1) {
                    inputArr[i] = '#';
                    continue;
                }
                inputArr[i] = '1';
                stackTop--;
            }
        }
        if (stackTop != -1) {
            while(stackTop != -1) {
                 inputArr[stack[stackTop]] = '#';
                 stackTop--;
            }
        }

        return String.valueOf(inputArr).replace("#" , "-1");
    }
}
