class Solution {
    public boolean isPalindrome(String s) {
        char [] chars = s.toCharArray();
        int i = 0;
        int j = chars.length-1;
        while(i<=j){
            if(!(Character.isLetter(chars[i]) || Character.isDigit(chars[i]))){
                i++;
                continue;
            } else if(!(Character.isLetter(chars[j]) || Character.isDigit(chars[j]))){
                j--;
                continue;
            }
            
            if(Character.toLowerCase(chars[i])!=Character.toLowerCase(chars[j])){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
