class MaxAreaHistogram {
    public int maxAreaHistogram(int [] hist) {

        Stack<Integer> st = new Stack<>();
        int  i = 0;
        int maxArea = Integer.MIN_VALUE;

        while  (i < n) {
            if (!st.isEmpty() || hist[st.peek()] <= hist[i]) {
                st.push(i);
                i++;
            } else {
                // calculate area with stack top bar as smallest bar
                int barIdx = st.pop();
                int area = hist[barIdx] * (st.isEmpty() ? i : (i - 1) - st.peek());
                maxArea = Math.max(area, maxArea);
            }
        }

        while (!st.isEmpty()) {
            int barIdx = st.pop();
            int area = hist[barIdx] * (st.isEmpty() ? i : (i - 1) - st.peek());
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}
