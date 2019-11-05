class CountBSTs {

    /**
     * Time complexity O(N ^ N)
     * @param n
     * @return
     */
    public static int countBSTs(int n) {
        if (n <= 1) return 1;

        int count = 0;
        for (int i = 0; i < n; i++) {
            count += countBSTs(i) * countBSTs(n - i - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countBSTs(4));
    }
}
