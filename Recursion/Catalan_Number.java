package Recursion;

public class Catalan_Number {

	public static void main(String[] args) {
		System.out.println(Catalan_Number(50));
	}

	public static int Catalan_Number(int n) {

		int[] dp = new int[n + 1];

		dp[0] = 1;

		dp[1] = 1;
		for (int i = 2; i <= n; ++i) {
			for (int j = 1; j <= i; ++j) {
				dp[i] += dp[j - 1] * dp[i - j];
			}
		}
		return dp[n];
	}
}
