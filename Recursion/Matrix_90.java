package Recursion;

public class Matrix_90 {

	public static void main(String[] args) {

		int mat[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		printMatrix(mat);

		rotateMatrixTranspose(mat);

		System.out.println();
		System.out.println();

		printMatrix(mat);

	}

	public static void rotateMatrixTranspose(int[][] mat) {

		for (int i = 0; i < mat.length; i++) {
			for (int j = i; j < mat[0].length; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;
			}
		}

		int i = 0;
		int j = mat.length - 1;

		while (j > i) {
			for (int k = 0; k < mat.length; k++) {
				int temp = mat[k][i];
				mat[k][i] = mat[k][j];
				mat[k][j] = temp;
			}
			i++;
			j--;
		}

	}

	public static void rotateMatrix(int[][] matrix) {
		int length = matrix.length - 1;

		for (int i = 0; i <= (length) / 2; i++) {
			for (int j = i; j < length - i; j++) {

				// Coordinate 1
				int p1 = matrix[i][j];

				// Coordinate 2
				int p2 = matrix[j][length - i];

				// Coordinate 3
				int p3 = matrix[length - i][length - j];

				// Coordinate 4
				int p4 = matrix[length - j][i];

				// Swap values of 4 coordinates.
				matrix[i][j] = p4;
				matrix[j][length - i] = p1;
				matrix[length - i][length - j] = p2;
				matrix[length - j][i] = p3;
			}
		}
	}

	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
