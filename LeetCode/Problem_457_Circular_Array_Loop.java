class Solution {
    int N;
    int[] nums;

    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length < 2) return false;
        N = nums.length;
        this.nums = nums;
        for (int i = 0; i < N; i++)
            if (cycleExists(i)) return true;    
        
        return false;
    }
    
    private boolean cycleExists(int from) {
        int i = from;
        int cycleLength = 0;
        boolean foundCycle = false;
        boolean forwardDirection = nums[i] > 0;

        while (cycleLength++ < N) {
            i = Math.floorMod(i + nums[i], N);
            boolean newDirectionIsAlsoForward = nums[i] > 0;
            if (newDirectionIsAlsoForward != forwardDirection) return false;
            if (i == from) {
                foundCycle = true;
                break;
            }
        }
        
        return foundCycle && cycleLength > 1 && Math.abs(from - i) != 1;
    }
}
