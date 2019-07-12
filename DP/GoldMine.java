package DP;

public class GoldMine {

	public static void main(String[] args) {

		int[][] mat = { { 2, 6, 0, 5 }, { 0, 7, 5, 2 }, { 3, 0, 3, 7 }, { 8, 0, 2, 3 } };

		System.out.println(goldmine(mat));

	}

	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int goldmine(int[][] cost) {
		int[][] dp = new int[cost.length][cost[0].length];

		for (int c = dp[0].length - 1; c >= 0; c--) {
			for (int r = 0; r < dp.length; r++) {
				if (c == dp[0].length - 1) {
					dp[r][c] = cost[r][c];
				} else if (r == 0) {
					dp[r][c] = cost[r][c] + max(dp[r][c + 1], dp[r + 1][c + 1]);
				} else if (r == dp.length - 1) {
					dp[r][c] = cost[r][c] + max(dp[r][c + 1], dp[r - 1][c + 1]);
				} else {
					dp[r][c] = cost[r][c] + max(dp[r + 1][c + 1], dp[r][c + 1], dp[r - 1][c + 1]);
				}
			}
		}

		int max1 = dp[0][0];

		for (int i = 0; i < dp.length; i++) {
			max1 = Math.max(max1, dp[i][0]);
		}

		return max1;

	}

	public static int max(int... vals) {
		int max = vals[0];
		for (int i = 1; i < vals.length; i++) {
			max = Math.max(max, vals[i]);
		}
		return max;
	}

}
