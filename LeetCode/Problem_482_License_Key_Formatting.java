class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder result = new StringBuilder();
        
        int currentBlockCount = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            char current = S.charAt(i);
            if (current == '-') {
                continue;
            }
            
            if (currentBlockCount == K) {
                result.append('-');
                currentBlockCount = 0;
            }

            result.append(Character.toUpperCase(current));
            currentBlockCount++;
        }
        
        return result.reverse().toString();
    }
}
