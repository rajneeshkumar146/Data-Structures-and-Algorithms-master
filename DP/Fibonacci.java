package DP;

public class Fibonacci {

	public static void main(String[] args) {

		System.out.println(fabo(9));

	}

	private static int fabo(int n) {

		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			return 1;
		}

		if (n == 2) {
			return 2;
		}

		int[] dp = new int[n + 2];

		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {

			dp[i] = dp[i - 2] + dp[i - 1];

		}

		return dp[n];

	}

}
