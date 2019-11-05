class Solution {
    public List<String> findMissingRanges(int[] a, int lower, int upper) {
        List<String> res = new ArrayList<>();
        for(int i : a) {
            if(i > lower) res.add(lower+((i-1 > lower)?"->"+(i-1):""));
            if(i == upper) return res; // Avoid overflow
            lower = i+1;
        }
        if(lower <= upper) res.add(lower + ((upper > lower)?"->"+(upper):""));
        return res;
    }
}
