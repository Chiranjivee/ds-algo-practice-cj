class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char [] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            map.put(c[i], map.getOrDefault(c[i], 0) + 1);
        }
        
        for (int i = 0; i < c.length; i++) {
            if (map.get(c[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
