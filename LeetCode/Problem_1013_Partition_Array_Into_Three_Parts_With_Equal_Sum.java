class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) sum += A[i];
        if (sum % 3 != 0) return false;
        
        int target = sum / 3;
        int part = 0;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            part += A[i];
            if (part != target) continue;
            part = 0;
            count++;
            if (count == 3) return true;
        }
        
        return false;
    }
}
