package DP;

public class LongestPalindromic_Subsequence {

	public static void main(String[] args) {

		String str = "agbdba";
		lpsub(str);

	}

	private static void lpsub(String str) {
 		int n = str.length();

		int maxLength = -1;
		int startpoint = -1;
		int endpoint = -1;

		int[][] dp = new int[n][n];

		for (int diag = 0; diag < str.length(); diag++) {

			int sp = 0;
			int ep = diag;

			while (ep < str.length()) {

				if (diag == 0) {
					dp[sp][ep] = 1;
				} else if (str.charAt(sp) == str.charAt(ep)) {
					dp[sp][ep] = dp[sp + 1][ep - 1] + 2;
				} else {
					dp[sp][ep] = Math.max(dp[sp][ep - 1], dp[sp + 1][ep]);

				}

				sp++;
				ep++;
			}

		}

		printMatrix(dp);

		System.out.println(dp[0][dp.length - 1]);
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
