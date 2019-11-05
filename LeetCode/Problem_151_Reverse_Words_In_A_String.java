class Solution {
    public String reverseWords(String s) {
        if (s == null || s.equals("")) return s;
        s = s.trim();
        String[] parts = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = parts.length - 1; i >= 0; i--) {
            String temp = parts[i].trim();
            if (temp.equals("")) {
                continue;
            }
            builder.append(parts[i].trim());
            builder.append(" ");
        }
        
        if (builder.length() > 0) builder.setLength(builder.length() - 1);
        return builder.toString();
    }
}
