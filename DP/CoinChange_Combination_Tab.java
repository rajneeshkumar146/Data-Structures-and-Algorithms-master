package DP;

import java.util.ArrayList;

public class CoinChange_Combination_Tab {

	public static void main(String[] args) {

		int amt = 10;

		int[] coins = new int[] { 2, 3, 5, 6 };

		func(coins, 10);

	}

	public static void func(int[] denoms, int amt) {

		int[] dp = new int[amt + 1];

		ArrayList<String>[] path = new ArrayList[amt + 1];

		for (int i = 0; i < path.length; i++) {

			path[i] = new ArrayList<String>();

		}

		dp[0] = 1;
		path[0].add("");

		for (int i = 0; i < denoms.length; i++) {
			for (int j = denoms[i]; j <= amt; j++) {

				dp[j] = dp[j] + dp[j - denoms[i]];

				for (String str : path[j - denoms[i]]) {

					path[j].add(str + denoms[i]);

				}
			}
		}

		System.out.println(dp[dp.length - 1]);

		System.out.println(path[path.length - 1]);
	}

}
