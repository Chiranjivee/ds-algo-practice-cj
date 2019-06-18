class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        for (int[] update : updates) {

            int start = update[0];
            int end = update[1];
            int item = update[2];

            result[start] += item;
            if (end + 1 < result.length) {
                result[end + 1] -= item;
            }
        }

        for (int i = 1; i < result.length; i++) {
            result[i] += result[i - 1];
        }
        return result;
    }
}
