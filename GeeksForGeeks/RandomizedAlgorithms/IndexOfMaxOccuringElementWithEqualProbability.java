class Solution {
    public int getIdx(int [] arr) {
        int maxElement = getMaxElementInArray(arr);
        int maxFreq = getFreqOfMaxElementInArray(arr);

        int randomIdx = getRandomNumberInRange(1, maxFreq);
        return getXthOccuranceOfElement(randomIdx);
    }
}
