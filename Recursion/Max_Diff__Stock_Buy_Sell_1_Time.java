package Recursion;

public class Max_Diff__Stock_Buy_Sell_1_Time {

	public static void maxDiff(int arr[], int n) {

		int diff = arr[1] - arr[0];
		int curr_sum = diff;
		int max_sum = curr_sum;

		for (int i = 1; i < n - 1; i++) {

			diff = arr[i + 1] - arr[i];

			if (curr_sum > 0)
				curr_sum += diff;
			else
				curr_sum = diff;

			if (curr_sum > max_sum)
				max_sum = curr_sum;
		}

		System.out.println(max_sum);
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 5, 2, 0, 1, 4, 2 };

		maxDiff(arr, arr.length);

	}
}
