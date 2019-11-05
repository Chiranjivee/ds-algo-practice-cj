class Solution {
    public boolean isLongPressedName(String name, String typed) {
        char [] nameArr = name.toCharArray();
        char [] typedArr = typed.toCharArray();
        
        if (nameArr[0] != typedArr[0]) return false;
        
        int j = 0;
        int i = 0;
        char previous = '1';
        for (; i < name.length() && j < typed.length();) {
            char current = name.charAt(i);
            if (current == typed.charAt(j)) {
                j++;
                i++;
                previous = current;
                continue;
            } 
                
            if (previous == typed.charAt(j)) {
                j++;
            } else {
                return false;
            }
        }

        if (i != name.length()) return false;
        return true;
    }
}
