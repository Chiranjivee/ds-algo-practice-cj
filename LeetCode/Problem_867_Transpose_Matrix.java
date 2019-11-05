class Solution {
    public int[][] transpose(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int [][] res = new int[cols][rows];

        for (int i = 0; i < cols; i++)
            for (int j = 0; j < rows; j++) 
                res[i][j] = A[j][i];
       
        return res;
    }
}
