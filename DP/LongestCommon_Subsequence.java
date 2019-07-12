package DP;

public class LongestCommon_Subsequence {

	public static void main(String[] args) {
		String str = "AGGTAB";
		String str2 = "GXTXAYB";

		char[] x = str.toCharArray();

		char[] y = str2.toCharArray();

		System.out.println(func(x, y, str.length(), str2.length()));

	}

	public static int func(char[] x, char[] y, int a, int b) {

		int[][] dp = new int[a + 1][b + 1];

		for (int i = 0; i <= a; i++) {
			for (int j = 0; j <= b; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (x[i - 1] == y[j - 1]) {
					dp[i][j] = dp[i][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		printMatrix(dp);

		return dp[a][b];

	}

	public static void printMatrix(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
}
