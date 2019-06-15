class Solution {
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            for (String p : words) {
                if (text.startsWith(p, i)) {
                    ans.add(new int[]{i, i + p.length() - 1});
                }
            }
        }

        Collections.sort(ans, new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {
                int ret = x[0] - y[0];
                if (ret == 0) ret = x[1] - y[1];
                return ret;
            }
        });
        return ans.toArray(new int[0][]);
    }
}
