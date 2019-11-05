class Solution {
    public String countAndSay(int n) {
        StringBuilder prev = new StringBuilder("1");
        n--;
        while (n-- > 0) {
            StringBuilder current = new StringBuilder();
            for (int i = 0; i < prev.length();) {
                int count = 0;
                char currChar = prev.charAt(i);
                int j = i;
                while (j < prev.length() && prev.charAt(j) == currChar) {
                    count++;
                    j++;
                }
                i = j;
                current.append(count);
                current.append(currChar);
            }
            prev.setLength(0);
            prev.append(current.toString());
        }
        return prev.toString();
    }
}
