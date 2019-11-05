class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < 20 && Math.pow(x, i) <= bound; i++) {
            for (int j = 0; j < 20 && Math.pow(x, j) <= bound; j++) {
                int v = (int) Math.pow(x, i) + (int) Math.pow(y, j);
                if (v <= bound) seen.add(v);
            } 
        }
        return new ArrayList<>(seen);
    }
}
