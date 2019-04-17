class Solution {
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        
        int start = 0;
        int end = s.length() - 1;
        
        char [] c = s.toCharArray();
        
        while (start < end) {
            while (start < end && !vowels.contains(c[start]+"")) start++;
            while (start < end && !vowels.contains(c[end]+"")) end--;
            
            swap(c, start, end);
            start++;
            end--;
        }
        
        return String.valueOf(c);
    }
    
    public void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}
