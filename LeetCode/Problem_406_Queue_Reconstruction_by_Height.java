class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        int[][] res = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            int pos = people[i][1];
            for (int j = i; j > pos; j--) {
                res[j] = res[j - 1];
            }
            res[pos] = people[i];
        }
        return res;
    }
}
