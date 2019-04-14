class Solution {
    public void sortColors(int[] nums) {
        int [] colors = new int[3];
        for (Integer e : nums) colors[e]++;
        
        int idx = 0;
        int zeroCount = colors[0];
        for (int i = 0; i < zeroCount; i++) {
            nums[idx++] = 0;
        }
        
        int oneCount = colors[1];
        for (int i = 0; i < oneCount; i++) {
            nums[idx++] = 1;
        }
        
        int twoCount = colors[2];
        for (int i = 0; i < twoCount; i++) {
            nums[idx++] = 2;
        }
    }
}
