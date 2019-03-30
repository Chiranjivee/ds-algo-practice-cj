class Solution {
    /**
     * O(N) gives tle
     */
    public int findIntegers(int num) {
        if (num == 0) {
            return 1;
        } else if (num == 1) {
            return 2;
        } else if (num == 2) {
            return 3;
        } else if (num == 3) {
            return 3;
        }

        Set<Integer> isConsecutive = new HashSet<>();
        isConsecutive.add(3);

        int last = 3;
        for (int i = 4; i <= num; i++) {
            if (!currentNumHasConsecutiveOnes(i, isConsecutive)) {
                ++last;
            }
        }
        return last;
    }

    public boolean currentNumHasConsecutiveOnes(int num, Set<Integer> isConsecutive) {
        if (isConsecutive.contains(num >> 1)) {
            isConsecutive.add(num);
            return true;
        }

        int last = num & 1;
        int secLast = (num >> 1) & 1;
        if (last == 1 && secLast == 1) {
            isConsecutive.add(num);
            return true;
        }

        return false;
    }
}
