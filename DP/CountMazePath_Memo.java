package DP;

public class CountMazePath_Memo {

	public static void main(String[] args) {
		int n = 15;

		System.out.println(func(0, 0, n, n, new int[n + 1][n + 1]));

	}

	public static int func(int sr, int sc, int dr, int dc, int dp[][]) {

		if (sr == dr && sc == dr) {
			return 1;
		}

		if (sr > dr || sc > dc) {
			return 0;
		}

		if (dp[sc][sr] != 0) {
			return dp[sc][sr];
		}

		int ih_to_d = func(sr, sc + 1, dr, dc, dp);

		int iv_to_d = func(sr + 1, sc, dr, dc, dp);

		int s_to_d = ih_to_d + iv_to_d;

		dp[sr][sc] = s_to_d;

		return s_to_d;

	}

}
