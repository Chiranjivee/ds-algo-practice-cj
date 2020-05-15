class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> jewels = new HashSet<>();
        for (Character c : J.toCharArray()) {
            jewels.add(c);
        }
        
        int count = 0;
        for (Character stone : S.toCharArray()) {
            if (jewels.contains(stone)) {
                count++;
            }
        }

        return count;
    }
}
