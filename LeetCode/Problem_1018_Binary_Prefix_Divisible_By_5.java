class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>();
        int currentNum = 0;
        
        for (int i = 0; i < A.length; i++) {
            currentNum <<= 1;
            currentNum |= A[i];
            currentNum %= 5;
            result.add(currentNum == 0);
        }

        return result;
    } 
}
