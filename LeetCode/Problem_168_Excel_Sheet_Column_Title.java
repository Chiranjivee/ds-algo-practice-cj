class Solution {
    public String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        
        while (n > 0)
        {
            int rem = n % 26 == 0 ? 26 : n % 26;
            char c = (char) (65 + rem - 1);
            builder.append(c);
            n = (n - rem) / 26;
            i++;
        }
        return builder.reverse().toString();
    }
}
