class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       Arrays.sort(candidates);
        
        List<List<Integer>> result = new ArrayList<>();
        computeCombinationSum(candidates, target, new ArrayList<>(), result, 0);
        return result;
    }
    
    public void computeCombinationSum(int [] candidates, int target, List<Integer> curr, List<List<Integer>> result, int start) {
        if (target < 0) {
            return;
        }
        
        if (target == 0) {
            result.add(new ArrayList<>(curr));
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            curr.add(candidates[i]);
            computeCombinationSum(candidates, target - candidates[i], curr, result, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
