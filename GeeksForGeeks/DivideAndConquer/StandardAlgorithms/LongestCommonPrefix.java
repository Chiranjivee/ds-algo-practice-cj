class LongestCommonPrefix {
    public String getLongestCommonPrefix(String [] strings, int start, int end) {
        if (start == end) {
            return strings[start];
        }

        int mid = (start + end) / 2;
        String leftPrefix = getLongestCommonPrefix(strings, start, mid);
        String rightPrefix = getLongestCommonPrefix(strings, mid + 1, end);

        return getPrefixFrom(leftPrefix, rightPrefix);
    }

    public String getPrefixFrom(String leftPrefix, String rightPrefix) {
        if (leftPrefix.length() == 0 || rightPrefix.length() == 0) {
            return "";
        }
        StringBuilder prefix = new StringBuilder();
        int i = 0; 
        int j = 0;

        for (int i = 0; i < Math.min(leftPrefix.length(), rightPrefix.length()), i++) {
            if (leftPrefix.charAt(i) == rightPrefix.charAt(i)) {
                prefix.append(leftPrefix.charAt(i));
            } else {
                break;
            }
        }

        return prefix.toString();
    }
}
