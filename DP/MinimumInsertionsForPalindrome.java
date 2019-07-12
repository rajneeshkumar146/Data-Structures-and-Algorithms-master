package DP;

public class MinimumInsertionsForPalindrome {

	public static void main(String[] args) {

		String str = "geeks";

		System.out.println(mip(str));

	}

	public static int mip(String str) {

		StringBuffer temp = new StringBuffer(str);
		temp.reverse();

		String rstr = temp.toString();

		int n = str.length();

		return (n - LCS(str, rstr, n));

	}

	public static int LCS(String str1, String str2, int n) {
		int[][] dp = new int[n + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[n][n];

	}
}
