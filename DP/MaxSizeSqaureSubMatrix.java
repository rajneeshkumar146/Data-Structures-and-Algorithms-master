package DP;

public class MaxSizeSqaureSubMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int mat[][] = { { 1, 0, 1, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 0, 1 }, { 1, 1, 1, 1, 0, 0 },
				{ 1, 1, 1, 1, 1, 1 }, { 0, 0, 1, 1, 1, 0 } };

		func(mat);

	}

	public static void func(int[][] mat) {

		printMatrix(mat);
		System.out.println();

		int maxsize = -1;

		int r = mat.length - 1;
		int c = mat[0].length - 1;

		int[][] dp = new int[mat.length][mat[0].length];

		for (int i = 0; i <= r; i++) {
			for (int j = 0; j <= c; j++) {

				if (mat[i][j] == 0) {
					dp[i][j] = 0;
				}

				if (j == r) {
					dp[i][j] = mat[i][j];
				}

				if (i == c) {
					dp[i][j] = mat[i][j];
				}

			}
		}

		for (int i = r - 1; i >= 0; i--) {
			for (int j = c - 1; j >= 0; j--) {

				if (mat[i][j] != 0) {

					dp[i][j] = 1 + Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i + 1][j + 1]);

					maxsize = Math.max(dp[i][j], maxsize);
				}
			}
		}

		printMatrix(dp);
		System.out.println();
		System.out.println("Max Size :- " + maxsize);
		System.out.println();
		for (int i = 0; i < maxsize; i++) {
			for (int j = 0; j < maxsize; j++) {

				System.out.print(1 + " ");

			}
			System.out.println();
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
