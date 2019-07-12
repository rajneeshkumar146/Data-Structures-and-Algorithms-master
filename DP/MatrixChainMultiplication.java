package DP;

public class MatrixChainMultiplication {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50, 60 };

		System.out.println(func(arr, 0, arr.length - 1, new int[arr.length][arr.length]));

	}

	public static int func(int[] arr, int sp, int ep, int[][] qb) {

		if (ep - sp == 1) {
			return 0;
		}

		if (qb[sp][ep] != 0) {
			return qb[sp][ep];
		}

		int min = Integer.MAX_VALUE;
		for (int cp = sp + 1; cp <= ep - 1; cp++) {
			int mcostp1 = func(arr, sp, cp, qb);
			int mcostp2 = func(arr, cp, ep, qb);

			int mycost = arr[sp] * arr[ep] * arr[cp];

			int totalcost = mcostp1 + mcostp2 + mycost;
			min = Math.min(totalcost, min);
		}

		qb[sp][ep] = min;

		return min;
	}
}
