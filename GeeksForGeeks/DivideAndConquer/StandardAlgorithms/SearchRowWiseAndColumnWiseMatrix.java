class SerachRowWiseAndColWiseMatrix {
    public int search(int [][] matrix, int fromRow, int toRow, int fromCol, int toCol, int key) {

        int i = fromRow + (toRow - fromRow) / 2;
        int j = fromCol + (toCol - fromCol) / 2;

        if (matrix[i][j] == key) {
            printFound(i, j);
            return;
        }

        // also top - right corner will always be searched.
        if (i != toRow || j != toCol)
            search(matrix, fromRow, i, j, toCol, key);

            if (fromRow == toRow && fromCol + 1 == toCol)
                if (matix[fromRow][toCol] == key) 
                    System.out.println("Found "+ key+ " at "+ fromRow + " " + toCol);

        if (matrix[i][j] < key) {
            // search in lower half;
            if (i + 1 < matrix.length)
                search(matrix, i + 1, toRow, fromCol, toCol, key);
        } else {
            if (j - 1 >= 0) {
                search(matrix, fromRow, toRow, fromCol, j - 1, key);
            }
        }
    }
}
