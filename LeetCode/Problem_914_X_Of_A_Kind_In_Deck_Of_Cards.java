class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] sol = new int[10000 + 1];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < deck.length; i++) {
            map.put(deck[i], map.getOrDefault(deck[i], 0) + 1);
        }

        int res = 0;
        for (Integer e : map.values()) {
            res = gcd(e, res);
        }
        return res > 1;
    }

    public int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }
}
