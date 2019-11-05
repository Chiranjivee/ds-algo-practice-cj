class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int n1Len = num1.length() - 1;
        int n2Len = num2.length() - 1;
        
        int i = 0; int j = 0;
        int x = 0;
        int y = 0;
        int c = 0;
        while (n1Len >= 0 || n2Len >= 0) {
            x = (n1Len < 0) ? 0 : Character.getNumericValue(num1.charAt(n1Len));
            y = (n2Len < 0) ? 0 : Character.getNumericValue(num2.charAt(n2Len));
            
            builder.append((x + y + c) % 10);
            c = (x + y + c) / 10;
            n1Len--;
            n2Len--;
        }
        
        if (c != 0) builder.append(c);
        return builder.reverse().toString();
    }
}
