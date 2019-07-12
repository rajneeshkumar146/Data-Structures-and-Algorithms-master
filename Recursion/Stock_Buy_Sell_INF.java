package Recursion;

public class Stock_Buy_Sell_INF {

	public static void main(String[] args) {
		int arr[] = { 7, 1, 5, 3, 6, 4 };

		func(arr);
	}

	private static void func(int[] arr) {
		int min = Integer.MAX_VALUE;
		int profit = 0;

		for (int prices : arr) {
			if (min < prices) {
				profit += prices - min;
			}
			min = prices;
		}

		System.out.println(profit);
	}

}
