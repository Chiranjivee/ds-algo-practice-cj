class Solution {

    public static boolean isPermutationAValidPalindrome(String input) {
        char [] arr = input.toCharArray();
        
        char xor = 0;
        for (int i = 1; i < arr.length; i++) {
            xor ^= arr[i];
        }
        System.out.println(xor);
        System.out.println("ArrayLeng:" + arr.length);
        if (arr.length % 2 == 0) {
            return xor == 0;
        }


        // compute xor again skipping this char
        char newxor = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == xor) {
                System.out.println("Skiping: " + arr[i]);
                continue;
            }

            newxor ^= arr[i];
        }
        return newxor == 0;
    }


    public static void main(String [] args) {
        System.out.println(Solution.isPermutationAValidPalindrome("aba"));
    }
}