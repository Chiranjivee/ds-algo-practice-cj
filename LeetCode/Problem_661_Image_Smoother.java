class Solution {
    public int[][] imageSmoother(int[][] M) {
        int rows = M.length;
        int cols = M[0].length;
        int [][] res = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sum = M[i][j];
                int count = 1;
                
                // take 3 above cols
                if (i - 1 >= 0) {
                    sum+= M[i - 1][j];
                    count++;
                    if (j - 1 >= 0) {
                        sum += M[i - 1][j - 1]; 
                        count++;
                    }
                    
                    if (j + 1 < cols) {
                        sum += M[i - 1][j + 1];
                        count++;
                    }
                }
                
                // take 3 below cols
                if (i + 1 < rows) {
                    sum += M[i + 1][j];
                    count++;
                    if (j - 1 >= 0) {
                        sum += M[i + 1][j - 1]; 
                        count++;
                    }
                    
                    if (j + 1 < cols) {
                        sum += M[i + 1][j + 1];
                        count++;
                    }
                }
                
                if (j - 1 >= 0) {
                    sum += M[i][j - 1];
                    count++;
                }
                
                if (j + 1 < cols) {
                    sum += M[i][j + 1];
                    count++;
                }
                
                res[i][j] = sum / count;
            }
        }
        return res;
    }
}
