class Solution {
    public List<Integer> findClosestElements(int[] array, int k, int x) {
        List<Integer> arr = new ArrayList<>();
        for (int e : array) arr.add(e);
        Collections.sort(arr, (a,b) -> a == b ? a - b : Math.abs(a-x) - Math.abs(b-x));
        arr = arr.subList(0, k);
        Collections.sort(arr);
        return arr;
    }
}
