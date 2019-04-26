class Solution {
    public int compress(char[] chars) {
        int index = 0; int indexAns = 0;
        
        while (index < chars.length) {
            char currentChar = chars[index];
            
            int count = 0;
            while (index < chars.length && currentChar == chars[index]) {
                count++;
                index++;
            }
            
            chars[indexAns++] = currentChar;
            if (count != 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[indexAns++] = c;
                }
            }
        }
        
        return indexAns;
    }
}
