class Solution {
    public boolean isArmstrong(int N) {
        String str = String.valueOf(N);
        int n = str.length();
        int curr = 0;
        for(char c : str.toCharArray()) {
            curr += (int) Math.pow(c-'0', n);
        }
        return curr == N;
    }
}
