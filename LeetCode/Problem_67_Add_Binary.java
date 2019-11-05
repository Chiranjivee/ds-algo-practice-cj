class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int c = 0;
        
        StringBuilder builder = new StringBuilder();
        
        while (i >= 0 || j >= 0) {
            int x = i < 0 ? 0 : Character.getNumericValue(a.charAt(i));
            int y = j < 0 ? 0 : Character.getNumericValue(b.charAt(j));
            
            int res = (x + y + c) % 2;
            c = (x + y + c) / 2;
            
            builder.append(res);
            i--;
            j--;
        }
        
        if (c != 0) builder.append(c);
        return builder.reverse().toString();
    }
}
