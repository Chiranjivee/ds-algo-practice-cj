class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> list = new ArrayList<>();
        int c = 0;
        for (int i = A.length - 1; i >= 0 || K > 0; i--) {
            int x = i >= 0 ? A[i] : 0;
            int y = K % 10;
            
            int res = (x + y + c) % 10;
            list.add(0, res);
            c = (x + y + c) / 10;
            K = K / 10;
            
        }
        
        if (c != 0) list.add(0, c);
        return list;
    }
}
