class Solution {
    static int calcMaxValue(String str) {
        int res = str.charAt(0) - '0';
    
        // Start traversing the string 
        for (int i = 1; i<str.length(); i++) {

            if (str.charAt(i) == '0' || str.charAt(i) == '1' || res < 2)
                res += (str.charAt(i) - '0');
    
            // Else multiply 
            else res *= (str.charAt(i) - '0');
        }
    
        // Return maximum value 
        return res;
    }
}
