class Solution {
    private List<Integer> ans;
    private int N;
    
    public List<Integer> lexicalOrder(int n) {
        this.ans = new ArrayList<>();
        this.N = n;
        for (int i = 1; i <= Math.min(n, 9); i++) {
            dfs(i);
        }
        
        return ans;
    }
    
    private void dfs(int num) {
        ans.add(num);
        
        for (int i = 0; i <= 9; i++) {
            if (num * 10 + i <= N) {
                dfs(num * 10 + i);
            }
        }
    }
}
