class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0; int sumB = 0;
        for (Integer e : A) sumA += e;
        for (Integer e : B) sumB += e;
        int delta = (sumB -sumA)/2;

        Set<Integer> setB = new HashSet<>();
        for (int x : B) setB.add(x);
        
        for (int x : A){
            if (setB.contains(x + delta)) {
                return new int[] { x, x + delta };
            }
        }
        throw null;
    }
}
