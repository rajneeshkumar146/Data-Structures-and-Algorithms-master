package Recursion;

public class Incl_Excl_No_Adjacent_Sum_Circular {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 1 };

		System.out.println(Math.max(max1(arr), max2(arr)));

	}

	private static int max1(int[] arr) {

		int n = arr.length;

		int dp[] = new int[n];

		int max1 = -1;
		for (int i = 0; i < n; i++) {
			dp[i] = arr[i];
		}

		for (int i = 2; i < n - 1; i++) {

			for (int j = 0; j < i - 1; j++) {

				if (dp[i] < dp[j] + arr[i]) {
					dp[i] = dp[j] + arr[i];
				}

				if (max1 < dp[i]) {
					max1 = dp[i];
				}

			}
		}

		dp = new int[n];

		int max2 = -1;
		for (int i = 0; i < n; i++) {
			dp[i] = arr[i];
		}

		for (int i = 3; i < n - 1; i++) {
			for (int j = 1; j < i - 1; j++) {

				if (dp[i] < dp[j] + arr[i]) {
					dp[i] = dp[j] + arr[i];
				}

				if (max2 < dp[i]) {
					max2 = dp[i];
				}

			}
		}

		return Math.max(max1, max2);

	}

	private static int max2(int[] arr) {

		int n = arr.length;

		int dp[] = new int[n];

		int max = -1;
		for (int i = 0; i < n; i++) {
			dp[i] = arr[i];
		}

		for (int i = 3; i < n - 1; i++) {
			for (int j = 1; j < i - 1; j++) {

				if (dp[i] < dp[j] + arr[i]) {
					dp[i] = dp[j] + arr[i];
				}

				if (max < dp[i]) {
					max = dp[i];
				}

			}
		}

		return max;

	}

}
