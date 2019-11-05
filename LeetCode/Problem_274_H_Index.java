class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int left = 0, len = citations.length, right = len - 1, mid = 0;

        while (left <= right) {
            mid = (left + right) >> 1;
            if (citations[mid] == (len - mid))
                return citations[mid];
            else if (citations[mid] > (len - mid))
                right = mid - 1;
            else
                left = mid + 1;
        }
        return len - (right + 1);
    }
}
