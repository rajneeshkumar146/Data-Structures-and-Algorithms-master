package DP;

public class Target_sum_subset {

	public static void main(String[] args) {
		int arr[] = { 3, 34, 4, 12, 5, 2 };
		int sum = 9;

		System.out.println(func(arr, sum));
	}

	public static boolean func(int[] arr, int sum) {
		int n = arr.length;

		boolean dp[][] = new boolean[n + 1][sum + 1];

		for (int i = 0; i < dp.length; i++) {

			for (int j = 0; j < dp[0].length; j++) {

				if (j == 0) {

					dp[i][j] = true;
				} else if (i >= 1 && dp[i - 1][j]) {

					dp[i][j] = dp[i - 1][j];
				} else if (i >= 1 && j - arr[i - 1] >= 0) {

					dp[i][j] = dp[i - 1][j - arr[i - 1]];
				}
			}
		}
		return dp[arr.length][sum];

	}

	public static int findTargetSumWays(int[] nums, int S) {
		int sum = 0;
		for (int num : nums)
			sum += num;
		if (sum < S || (sum + S) % 2 == 1)
			return 0;
		int s = (sum + S) / 2;
		int[] dp = new int[s + 1];
		dp[0] = 1;
		for (int n : nums)
			for (int i = s; i >= n; i--)
				dp[i] += dp[i - n];
		return dp[s];
	}
}
