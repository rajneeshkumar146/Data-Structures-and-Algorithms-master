package DP;

public class CountPalindromic_Subsequence {

	public static void main(String[] args) {

		String str = "agbdba";

		System.out.println(cps(str));

	}

	private static int cps(String str) {
		int N = str.length();

		int[][] dp = new int[N][N];

		for (int diag = 0; diag < str.length(); diag++) {

			int sp = 0;
			int ep = diag;

			while (ep < str.length()) {
				if (diag == 0) {
					dp[sp][ep] = 1;
				} else if (str.charAt(sp) == str.charAt(ep)) {

					dp[sp][ep] = dp[sp][ep - 1] + dp[sp + 1][ep] + 1;

				} else {
					dp[sp][ep] = dp[sp][ep - 1] + dp[sp + 1][ep] - dp[sp + 1][ep - 1];
				}

				sp++;
				ep++;

			}

		}

		printMatrix(dp);

		return dp[0][N - 1];
	}

	private static void printMatrix(int[][] cps) {
		for (int i = 0; i < cps.length; i++) {
			for (int j = 0; j < cps[0].length; j++) {

				System.out.print(cps[i][j] + " ");

			}
			System.out.println();
		}
	}
}
