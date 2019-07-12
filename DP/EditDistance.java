package DP;


public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "acrdey";

		String str2 = "abcgdy";

		func(str, str2);
	}

	public static void func(String str, String str2) {

		int[][] dp = new int[str.length() + 1][str2.length() + 1];

		for (int i = 0; i < dp.length; i++) {

			dp[i][0] = i;

		}

		for (int i = 0; i < dp[0].length; i++) {

			dp[0][i] = i;

		}

		for (int i = 0; i < dp.length; i++) {

			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}

			System.out.println();
		}

		for (int i = 1; i < dp.length; i++) {

			for (int j = 1; j < dp[0].length; j++) {

				if (str.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
				}
			}

		}

		System.out.println();

		for (int i = 0; i < dp.length; i++) {

			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}

			System.out.println();
		}

		System.out.println();
		System.out.println(dp[dp.length - 1][dp[0].length - 1]);

	}

}
