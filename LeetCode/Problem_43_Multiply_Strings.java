class MultiplyStrings {

    public static void main(String[] args) {
        MultiplyStrings multStr = new MultiplyStrings();
        String tes = multStr.multiply("922222222", "4567890");
        System.out.println(tes);
    }

    public String multiply(String num1, String num2) {
        if (num1.length() == 1 && num1.equals("0") || num2.length() == 1 && num2.equals("0")) return "0";
        StringBuilder finalResult = new StringBuilder();
        int len2 = num2.length() - 1;
        for (int i = num2.length() - 1; i >= 0; i--) {
            int currentNum = num2.charAt(i) - '0';
            System.out.println("Current Num: " + currentNum);

            int carry = 0;
            StringBuilder tempResult = new StringBuilder();
            for (int j = num1.length() - 1; j >= 0; j--) {
                int tempNum = carry + currentNum * (num1.charAt(j) - '0');
                
                carry = tempNum / 10;
                tempNum = tempNum % 10;
                tempResult.append(tempNum);

            }

            if (carry != 0) tempResult.append(carry);
            System.out.println(tempResult.reverse().toString());

            int appendZeroCount = len2 - i;
            while (appendZeroCount > 0) {
                tempResult.append(0);
                appendZeroCount--;
            }

            finalResult = add(finalResult.toString(), tempResult.toString());
        }
        return finalResult.toString();
    }
    
    public StringBuilder add(String num1, String num2) {
        System.out.println("Adding: " + num1 + ", " + num2);
        StringBuilder result = new StringBuilder();
        
        int i = num1.length() - 1; int j = num2.length() - 1;
        int a = 0;
        int b = 0;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            if (i < 0) a = 0;   
            else a = num1.charAt(i) - '0';

            if (j < 0) b = 0;  
            else b = num2.charAt(j)  - '0';

            int temp = (a + b + carry);
            carry = temp / 10;
            temp = temp % 10;
            result.append(temp);
            i--; j--;
        }
        
        if (carry != 0) result.append(carry);
        return result.reverse();
    }
}
