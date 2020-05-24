class Solution {
    public int trap(int[] height) {
        
        int left = 0;
        int right = height.length - 1;
        int currentHeight = 0;
        int volume = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                currentHeight = Math.max(currentHeight, height[left]);
                volume += currentHeight -  height[left];
                left++;
            } else {
                currentHeight = Math.max(currentHeight, height[right]);
                volume += currentHeight -  height[right];
                right--;
            }
        }

        return volume;
    }
}
