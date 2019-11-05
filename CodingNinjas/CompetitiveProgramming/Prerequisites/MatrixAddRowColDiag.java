import java.util.Scanner;

public class MatrixAddRowColDiag {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int[][] mat = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				mat[i][j] = in.nextInt();
			}
		}

		int diagSum = 0;
		for (int i = 0; i < size; i++) {
			if (i == (size - 1 - i)) {
				diagSum += mat[i][i];
			} else {
				diagSum += mat[i][i];
				diagSum += mat[i][size - i - 1];
			}
		}

		int result = diagSum + getRowSumExcludingFirstAndLast(0, mat) + getColSumExcludingFirstAndLast(0, mat)
				+ getRowSumExcludingFirstAndLast(size - 1, mat) + getColSumExcludingFirstAndLast(size - 1, mat);

		System.out.println(result);

	}

	public static int getRowSumExcludingFirstAndLast(int row, int[][] mat) {
		int result = 0;
		for (int i = 1; i < mat[row].length - 1; i++) {
			result += mat[row][i];
		}
		return result;
	}

	public static int getColSumExcludingFirstAndLast(int col, int[][] mat) {
		int result = 0;
		for (int i = 1; i < mat[col].length - 1; i++) {
			result += mat[i][col];
		}
		return result;
	}
}
