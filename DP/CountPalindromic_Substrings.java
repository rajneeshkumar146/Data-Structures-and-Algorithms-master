package DP;

public class CountPalindromic_Substrings {

	public static void main(String[] args) {

		String str = "abccbc";

		func(str);

	}

	public static void func(String str) {

		int ctr = 0;
		boolean[][] dp = new boolean[str.length()][str.length()];

		for (int diag = 0; diag < str.length(); diag++) {

			int sp = 0;
			int ep = diag;

			while (ep < str.length()) {

				if (diag == 0) {

					dp[sp][ep] = true;
				} else if (diag == 1) {

					if (str.charAt(sp) == str.charAt(ep)) {
						dp[sp][ep] = true;
					}
				} else {
					if (str.charAt(sp) == str.charAt(ep) && dp[sp + 1][ep - 1] == true) {
						dp[sp][ep] = true;
					}
				}

				if (dp[sp][ep] == true) {
					ctr++;
				}

				sp++;
				ep++;

			}
		}

		printMatrix(dp);

		System.out.println(ctr);

	}

	private static void printMatrix(boolean[][] dp) {
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (dp[i][j] == true) {
					System.out.print("T" + " ");
				} else {
					System.out.print("F" + " ");
				}

			}
			System.out.println();
		}
	}

}