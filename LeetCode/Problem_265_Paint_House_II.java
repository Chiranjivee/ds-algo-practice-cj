class Solution {
    Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
    public int minCostII(int[][] costs) {
        if(costs.length == 0) return 0;
        return solve(costs, 0, -1, costs[0].length);
    }
    
    private int solve(int[][] costs, int start, int prev, int k) {
        if(start == costs.length) return 0;
        
        if(map.containsKey(start) && map.get(start).containsKey(prev)) return map.get(start).get(prev);
        int val = Integer.MAX_VALUE;
        for(int i=0; i<k; i++) {
            if(i == prev) continue;
            val = Math.min(val, solve(costs, start+1, i, k)+costs[start][i]);
        }

        Map<Integer, Integer> subMap = map.getOrDefault(start, new HashMap<Integer, Integer>());
        subMap.put(prev, val);
        map.put(start, subMap);
        return val;
    }
}
