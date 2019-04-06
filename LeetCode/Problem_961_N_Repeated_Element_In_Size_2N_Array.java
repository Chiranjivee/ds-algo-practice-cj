class Solution {
    public int repeatedNTimes(int[] A) {
        int res = 0;
        HashMap<Integer, Integer> intCount = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int count = intCount.getOrDefault(A[i], 0);
            intCount.put(A[i], ++count);
            if (count == A.length / 2) res = i;
        }
        return A[res];
    }
}
