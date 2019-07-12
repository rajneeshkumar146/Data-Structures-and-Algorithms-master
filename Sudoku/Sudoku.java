package Sudoku;

import java.util.Arrays;
import java.util.Scanner;

public class Sudoku {

	static Scanner scn = new Scanner(System.in);

	static int[] numR = new int[10];

	static int[] numC = new int[10];
	static int[] numMM = new int[10];

	public static void sudoku(int[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix.length; col++) {

				if (matrix[row][col] == 0) {

					rowcheck(matrix, col);
					colcheck(matrix, row);
					matrixcheck(matrix, row, col);
					placenumber(matrix, row, col);
				}
			}

		}

	}

	public static void rowcheck(int[][] matrix, int col) {

		for (int r = 0, i = 0; r < matrix.length && i <= numR.length - 1; i++, r++) {
			if (matrix[r][col] != 0) {

				numR[i] = matrix[r][col];
			}
		}
	}

	public static void colcheck(int[][] matrix, int row) {

		for (int c = 0, i = 0; c < matrix[0].length && i <= numC.length - 1; i++, c++) {
			if (matrix[row][c] != 0) {

				numC[i] = matrix[row][c];

			}
		}
	}

	@SuppressWarnings("unused")
	public static void matrixcheck(int[][] matrix, int row, int col) {

		int nr = 3 * (row / 3);
		int nc = 3 * (col % 3);
		for (int i = 0; i < nr + 3; i++) {
			for (int j = 0; j < nc + 3; j++) {

				if (matrix[nr][nc] != 0) {

					for (int x = 0; x <= numMM.length - 1; x++) {
						numMM[x] = matrix[nr][nc];
						break;
					}
				}

			}

		}

	}

	public static void placenumber(int[][] matrix, int row, int col) {
		for (int n = 1; n <= 9; n++) {
			for (int i = 0; i <= numR.length - 1; i++) {
				if (numR[i] != n) {
					for (int j = 0; j <= numC.length - 1; j++) {
						if (numC[i] != n) {
							for (int k = 0; k <= numMM.length - 1; k++) {
								if (numMM[k] != n) {
									matrix[row][col] = n;
								}
							}
						}

					}

				}

			}
		}
	}

	public static void main(String[] args) {

		Arrays.fill(numR, 0);
		Arrays.fill(numC, 0);
		Arrays.fill(numMM, 0);

		int[][] matrix = new int[9][9];

		for (int i = 0; i <= matrix.length - 1; i++) {
			for (int j = 0; j <= matrix[0].length - 1; j++) {

				matrix[i][j] = scn.nextInt();
			}
		}

		sudoku(matrix);
		System.out.println();

		for (int i = 0; i <= matrix.length - 1; i++) {
			for (int j = 0; j <= matrix[0].length - 1; j++) {

				System.out.print(matrix[i][j] + "  ");
			}
			System.out.println();
		}

		System.out.println();

		for (int i = 0; i <= numC.length - 1; i++) {
			System.out.print(numC[i] + "  ");
		}

		System.out.println();

		for (int i = 0; i <= numR.length - 1; i++) {
			System.out.print(numR[i] + "  ");
		}
		System.out.println();

		for (int i = 0; i <= numMM.length - 1; i++) {
			System.out.print(numMM[i] + "  ");
		}

	}
}
