package DP;

public class MinCostPath_Memo {
	public static void main(String[] args) {

		// int cost[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };

		int[][] cost = { { 2, 3, 0, 4 }, { 0, 6, 5, 2 }, { 8, 0, 3, 7 }, { 2, 0, 4, 2 } };

		func(cost, cost.length - 1, cost[0].length - 1);
	}

	public static void func(int[][] cost, int r, int c) {

		System.out.println();

		printMatrix(cost);

		int[][] dp = new int[r + 1][c + 1];

		dp[0][0] = cost[0][0];

		for (int i = 1; i <= r; i++) {
			dp[i][0] = dp[i - 1][0] + cost[i][0];
		}

		System.out.println();

		printMatrix(dp);

		for (int j = 1; j <= c; j++) {
			dp[0][j] = dp[0][j - 1] + cost[0][j];
		}

		System.out.println();

		printMatrix(dp);

		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + cost[i][j];
			}
		}

		System.out.println();

		printMatrix(dp);
		System.out.println();
		System.out.println(dp[dp.length - 1][dp[0].length - 1]);
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
