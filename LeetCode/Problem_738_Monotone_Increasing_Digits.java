class Solution {
    public int monotoneIncreasingDigits(int N) {
        String S = String.valueOf(N);
        
        String ans = "";
        
        search: for (int i = 0; i < S.length(); i++) {
            for (char d = '1'; d <= '9'; d++) {
                if (S.compareTo(ans + repeat(d, S.length() - i)) < 0) {
                    ans += (char) (d - 1);
                    continue search;
                }
            }
            
            ans += 9;
        }
        
        return Integer.parseInt(ans);
    }
    
    public String repeat(char c, int count) {
        StringBuilder sb = new StringBuilder(count);
        for (int i = 0; i < count; ++i) sb.append(c);
        return sb.toString();
    }
}
