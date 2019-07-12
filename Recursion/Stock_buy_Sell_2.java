package Recursion;

public class Stock_buy_Sell_2 {

	public static void main(String[] args) {
		int arr[] = { 2, 30, 15, 10, 8, 25, 80 };

		func(arr);
	}

	private static void func(int[] arr) {
		int[] left = new int[arr.length];

		int min = arr[0];

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] < min) {
				min = arr[i];
			} else {
				left[i] = Math.max(left[i - 1], arr[i] - min);
			}
		}

		int[] right = new int[arr.length];

		int max = arr[arr.length - 1];

		for (int i = arr.length - 2; i >= 0; i--) {
			if (max < arr[i]) {
				max = arr[i];
			} else {
				right[i] = Math.max(right[i + 1], max - arr[i]);
			}
		}

		int idx = 0;

		int maxProfit = Integer.MIN_VALUE;

		while (idx < arr.length) {
			if (left[idx] + right[idx] > maxProfit) {
				maxProfit = left[idx] + right[idx];
			}
			idx++;
		}
		System.out.println(maxProfit);

	}

}
