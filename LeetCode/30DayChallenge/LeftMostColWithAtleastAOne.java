/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        if (binaryMatrix == null) return -1;
        
        int row = binaryMatrix.dimensions().get(0);
        int col = binaryMatrix.dimensions().get(1);
        
        int currentRow = 0;
        int currentCol = col - 1;
        while (currentCol >= 0 && currentRow <= row - 1) {
            if (binaryMatrix.get(currentRow, currentCol) == 1) {
                currentCol--;
            } else {
                currentRow++;
            }
        }
        
        return currentCol == col - 1 ? -1 : currentCol + 1;
    }
}
