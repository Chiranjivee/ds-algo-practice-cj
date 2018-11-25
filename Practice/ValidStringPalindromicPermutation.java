class Solution {

    public static boolean isPermutationAValidPalindrome(String input) {
        char [] arr = input.toCharArray();
        
        char xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }

        if (arr.length % 2 == 0) {
            return xor == 0;
        }
        
        char newxor = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == xor) continue;
            newxor ^= arr[i];
        }
        return newxor == 0;
    }


    public static void main(String [] args) {
        System.out.println(Solution.isPermutationAValidPalindrome("ababab"));
        System.out.println(Solution.isPermutationAValidPalindrome("abab"));
    }
}