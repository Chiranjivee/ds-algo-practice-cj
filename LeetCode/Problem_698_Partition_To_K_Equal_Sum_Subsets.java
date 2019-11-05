class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+= nums[i];
        }
        
        if (sum % k != 0) return false;
        int [] visited = new int[nums.length];
        return canPartition(nums, visited, 0, k, 0, 0, sum / k);
    }
    
    public boolean canPartition(int [] nums, int [] visited, int idx, int k, int currSum, int elemInCurrSet, int target) {
        if (k == 1) return true;
        if (currSum == target && elemInCurrSet > 0) return canPartition(nums, visited, 0, k - 1, 0, 0, target);
        
        for (int i = idx; i < nums.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                if (canPartition(nums, visited, i + 1, k, currSum + nums[i], elemInCurrSet++, target)) return true;
                visited[i] = 0;
            }
        }
        return false;
    }
}
