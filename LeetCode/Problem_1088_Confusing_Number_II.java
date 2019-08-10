class Solution {
    
    Map<Integer, Integer> map;
    int N;
    int res;
    public int confusingNumberII(int N) {

        map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        res = 0;
        if (N == 1000000000) {
            res++;
            N--;
        }
        
        this.N = N;
        search(0, 0);
        return res;
    }
    
    private void search(int p, int cur) {
        if (p > 9 || cur > N) {
            return;
        }
        if (isConfusing(cur)) {
            res++;
        }
        for (Integer d : map.keySet()) {
            if (p == 0 && d == 0) {
                continue;
            }
            search(p + 1, cur * 10 + d);
        }
    }
    
    private boolean isConfusing(int n) {
        long rot = 0;
        int tmp = n;
        while (n > 0) {
            rot = rot * 10 + map.get(n % 10);
            n /= 10;
        }
        return rot != tmp;
    }
}
