package DP;

public class CountBoardPath_Memo {

	public static void main(String[] args) {
		System.out.println(cbpm(0, 10, new int[10 + 1]));

	}

	public static int cbpm(int s, int d, int[] dp) {

		if (s > d) {
			return 0;
		}

		if (s == d) {
			return 1;
		}

		if (dp[s] != 0) {
			return dp[s];
		}

		int s_to_d = 0;

		for (int dice = 1; dice <= 6; dice++) {

			int i = s + dice;

			int i_to_d = cbpm(i, d, dp);
			s_to_d += i_to_d;
		}

		dp[s] = s_to_d;
		return s_to_d;

	}
}
