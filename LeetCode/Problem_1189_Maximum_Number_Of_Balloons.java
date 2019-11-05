class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] map = new int[26];
        char[] chars = text.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            map[chars[i] - 'a']++;
        }

        int ans = text.length();
        for(int i = 0; i < map.length; i++) {
            char c = (char)(i + 'a');
            if (c == 'a' || c == 'b' || c == 'n') {
                ans = Math.min(ans, map[i]);
            } else if (c == 'l' || c == 'o') {
                ans = Math.min(ans, map[i] / 2);
            }
        }

        return ans;
    }
}
