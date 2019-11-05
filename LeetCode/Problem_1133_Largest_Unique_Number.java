class Solution {
    public int largestUniqueNumber(int[] A) {
        if(A==null || A.length==0) return -1;
        Map<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                return num2-num1;
            }
        });
        for(int num : A) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        for(int num : map.keySet()) {
            if(map.get(num)==1) {
                return num;
            }
        }
        return -1;
    }
}
