class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> st = new Stack<>();
        
        int [] ans = new int[T.length];
        
        for (int i = 0; i < T.length; i++) {
            while (!st.isEmpty() && T[i] > T[st.peek()]) {
                int last = st.pop();
                ans[last] = i - last;
            }

            st.push(i);
        }
        
        return ans;
    }
}
