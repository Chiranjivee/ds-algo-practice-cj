class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> input = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            input.add(i);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(input, k, n, new ArrayList<>(), result, 0);
        return result;
    }
    
    public void combinationSum(List<Integer> input, int k, int n, List<Integer> current, List<List<Integer>> result, int start) {
        if (current.size() == k) {
            if (n == 0) result.add(new ArrayList<>(current));
            return;
        }
        
        int remaining = k - current.size();
        for (int i = start; i < input.size() && i + remaining <= input.size(); i++) {
            current.add(input.get(i));
            combinationSum(input, k, n - input.get(i), current, result, i + 1);
            current.remove(current.size() - 1);
        }
    }
}
