class Solution {
    public String toLowerCase(String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            builder.append(Character.toLowerCase(str.charAt(i)));
        }
        return builder.toString();
    }
}