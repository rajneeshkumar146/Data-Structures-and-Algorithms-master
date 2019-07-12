package HashMap;

public class MinSwap_to_increasing {

	public static void minTransfer(int[] heights) {
		int[] dp = new int[heights.length + 1];

		int max = 0;
		for (int height : heights) {

			dp[height] = dp[height - 1] + 1;
			if (max < dp[height]) {
				max = dp[height];
			}
		}

		System.out.println(heights.length - max);
	}

	public static void main(String[] args) {
		int[] heights = { 4, 3, 1, 2 };

		minTransfer(heights);
	}

}
