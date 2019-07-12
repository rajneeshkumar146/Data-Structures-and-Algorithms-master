package Recursion;

public class Stock_Buy_Sell_1 {

	public static int maxProfit(final int[] A) {

		if (A.length == 0) {
			return 0;
		}

		int profit = -1;

		int max = A[A.length - 1];

		for (int i = A.length - 1; i >= 0; i--) {
			if (A[i] > max) {
				max = A[i];
			} else {
				profit = Math.max(profit, max - A[i]);
			}
		}

		if (max == A[A.length - 1]) {
			return 0;
		}

		return profit;

	}

	public static void main(String args[]) {

		int price[] = { 5, 9, 0, 1, 2, 4 };

		System.out.println(maxProfit(price));

	}
}
