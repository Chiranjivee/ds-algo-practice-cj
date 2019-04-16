class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            curr.add(candidates[i]);
            computeCombinationSum(candidates, target - candidates[i], curr, result, i);
            curr.remove(curr.size() - 1);
        }
    }
}
