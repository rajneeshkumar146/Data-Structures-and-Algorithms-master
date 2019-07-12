package DP;

public class RodCut_tab {

	public static void main(String[] args) {

		int[] arr = new int[] { 0, 3, 5, 6, 15, 10, 25, 12, 25 };

		func(arr);
	}

	public static void func(int[] arr) {

		int[] dp = new int[arr.length];

		String[] path = new String[arr.length];

		dp[0] = 0;
		path[0] = "#";

		dp[1] = arr[1];
		path[1] = "1";

		for (int i = 2; i < arr.length; i++) {

			dp[i] = arr[i];
			path[i] = i + " ";
			int left = 1;
			int right = i - 1;

			while (right > left) {

				if (dp[left] + dp[right] > dp[i]) {

					dp[i] = dp[left] + dp[right];
					path[i] = path[left] + " " + path[right];
				}

				left++;
				right--;
			}

		}

		System.out.println(dp[dp.length - 1] + " :- " + path[path.length - 1]);
	}

}
