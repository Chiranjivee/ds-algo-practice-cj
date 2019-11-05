class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int volume = 0;
        int currentTankHeight = 0;
        
        while (left < right) {
            if (height[left] < height[right]) {
                currentTankHeight = Math.max(currentTankHeight, height[left]);
                volume += currentTankHeight - height[left];
                left++;
            } else {
                currentTankHeight = Math.max(currentTankHeight, height[right]);
                volume += currentTankHeight - height[right];
                right--;
            }                        
        }

        return volume;
    }
}
