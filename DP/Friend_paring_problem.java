package DP;

public class Friend_paring_problem {

	public static void main(String[] args) {

		func(4);

	}

	public static void func(int n) {

		int[] dp = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			if (i <= 2)
				dp[i] = i;
			else
				dp[i] = dp[i - 1] + dp[i - 2] * (i - 1);
		}

		System.out.println(dp[n]);

	}

}
