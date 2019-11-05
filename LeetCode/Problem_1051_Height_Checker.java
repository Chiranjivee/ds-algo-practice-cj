class Solution {
    public int heightChecker(int[] heights) {
        int [] tempHeights = new int[heights.length];
        for (int i = 0; i < heights.length; i++) tempHeights[i] = heights[i];
        
        Arrays.sort(tempHeights);
        
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != tempHeights[i]) {
                result++;
            }
        }
            
        return result;
    }
}
