class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder builder = new StringBuilder();
        
        if (strs.length == 0) {
            return "";
        }

        int i = 0;
        while (i < strs[0].length() && builder.length() <= strs[0].length()) {
            builder.append(strs[0].charAt(i));
            for (String s : strs) {
                if (s.startsWith(builder.toString())) continue;
                else {
                    builder.setLength(builder.length() - 1);
                    break;
                }
            }    
            i++;
        }

        return builder.toString();
    }
}
