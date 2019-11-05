class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int maxArea = 0;
        int [][] temp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp[i][j] = Character.getNumericValue(matrix[i][j]);
            }
        }

        for (int i = 0; i < temp.length; i++) {
            if (i != 0) {
                for (int j = 0; j < temp[0].length; j++) {
                    temp[i][j] =
                        temp[i][j] == 0 ? 0 : temp[i - 1][j] + temp[i][j];
                }
            }
            
            int tempArea = largestRectangleArea(temp[i]);
            maxArea = Math.max(maxArea, tempArea);
        }
        
        return maxArea;
    }
    
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i];
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                int tp = stack.pop();
                maxArea = 
                    Math.max(
                        maxArea, 
                        heights[tp] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
                i--;
            }
        }
        return maxArea;
    }
}
