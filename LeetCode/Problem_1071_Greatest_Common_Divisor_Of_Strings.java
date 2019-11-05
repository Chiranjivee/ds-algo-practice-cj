class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return gcdOfStrings(str2, str1);
        } // make sure str1 is not shorter than str2.
        else if (!str1.startsWith(str2)) {
            return "";
        } // shorter string is not common prefix.
        else if (str2.isEmpty()) {
            return str1;
        } // gcd string found.
        else {
            return gcdOfStrings(str1.substring(str2.length()), str2);
        } // cut off the common prefix part of str1.
    }
}
