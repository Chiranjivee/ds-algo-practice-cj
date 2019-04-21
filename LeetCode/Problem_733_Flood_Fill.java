class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        
        fill(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    
    public int[][] fill(int [][] image, int sr, int sc, int newColor, int oldColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
            return image;
        }
        
        if (image[sr][sc] != oldColor) {
            return image;
        }
        
        image[sr][sc] = newColor;
        
        fill(image, sr + 1, sc, newColor, oldColor);
        fill(image, sr, sc + 1, newColor, oldColor);
        fill(image, sr - 1, sc, newColor, oldColor);
        fill(image, sr, sc - 1, newColor, oldColor);
        
        return image;
    }
}
