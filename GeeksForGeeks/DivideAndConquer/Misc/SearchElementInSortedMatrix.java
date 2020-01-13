class SearchElementInSortedMatrix {
    public void serach(int [][] matrix, int element) {
        int i = 0;
        int j = matrix.length - 1;

        while (j >= 0 && i < matrix.length) {
            if (matrix[i][j] == element) {
                return i * matrix.length + j;
            }

            if (matrix[i][j] > element) {                
                j--;
            } else {
                i++;
            }
        }

        return -1;
    }
}
