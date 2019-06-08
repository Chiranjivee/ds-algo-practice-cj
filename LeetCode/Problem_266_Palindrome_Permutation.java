class Solution {
    public boolean canPermutePalindrome(String s) {
        int [] memo = new int[256];
        
        for (int i = 0; i < s.length(); i++) {
            int currentCharIdx = s.charAt(i) - 'a' + 127;
            if (memo[currentCharIdx] == 1) {
                memo[currentCharIdx]--;
            } else {
                memo[currentCharIdx]++;
            }
        }
        
        int sum = 0;
        for (int i = 0; i < memo.length; i++) {
            sum += memo[i];
        }

        return sum == 1 || sum == 0 ? true : false;
    }
}
