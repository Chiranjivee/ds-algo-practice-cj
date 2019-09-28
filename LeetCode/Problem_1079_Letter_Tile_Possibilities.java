class Solution {
    private Set<String> set;

    public int numTilePossibilities(String tiles) {
        set = new HashSet<>();
        backtrack(tiles.toCharArray(), 0);
        return set.size();
    }

    private void backtrack(char[] chars, int i) {
        if (i >= 1) {
            set.add(String.valueOf(Arrays.copyOf(chars, i)));
        }
        
        if (i == chars.length) {
            return;
        }

        for (int j = i; j < chars.length; j++) {
            swap(chars, i, j);
            backtrack(chars, i + 1);
            swap(chars, i, j);
        }
    }

    private void swap(char[] chars, int i, int j) {
        
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
