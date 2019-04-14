class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }

        List<Integer> oneRow = new ArrayList<>();
        oneRow.add(1);
        res.add(oneRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> lastRow = res.get(i - 1);
            List<Integer> currRow = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    currRow.add(1);
                    continue;
                }

                currRow.add(lastRow.get(j) + lastRow.get(j - 1));
            }
            res.add(currRow);
        }
        return res;
    }
}
