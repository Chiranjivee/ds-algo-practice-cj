class StockSpanProblem {
    public void stockSpan(int [] stocks) {

        Stack<Integer> st =  new Stack<>();
        int [] result = new int[stocks.length];

        result[0] = 1;
        st.push(stocks[0]);
        for (int i = 1; i < stocks.length; i++) {
            while (!st.isEmpty() && st.peek() <= stocks[i]) {
                st.pop();
            }

            result[i] =  st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }

        System.out.println(Arrays.toString(result));
    }
}
