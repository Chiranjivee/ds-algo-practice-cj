class Solution {
    public String reverseWords(String s) {
        String[] parts = s.split(" ");

        StringBuilder builder = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (String part : parts) {
            temp.append(part);
            builder.append(temp.reverse());
            temp.setLength(0);
            builder.append(" ");
        }
        
        builder.setLength(builder.length() - 1);
        return builder.toString();
    }
}
