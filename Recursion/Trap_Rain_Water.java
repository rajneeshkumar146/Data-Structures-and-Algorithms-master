package Recursion;

public class Trap_Rain_Water {

	public static void main(String[] args) {

		int[] arr = { 0, 1, 0, 2, 1, 0, 1, 0, 2, 1, 2, 1 };

		func(arr);

	}

	public static void func(int[] arr) {

		int result = 0;

		int lo = 0;
		int hi = arr.length - 1;

		int left_max = 0;
		int right_max = 0;

		while (lo <= hi) {

			if (arr[lo] < arr[hi]) {
				if (arr[lo] > left_max) {
					left_max = arr[lo];
				} else {
					result += left_max - arr[lo];

					lo++;
				}
			}

			else {
				if (arr[hi] > right_max) {
					right_max = arr[hi];
				} else {
					result += right_max - arr[hi];

					hi--;
				}
			}
		}

		System.out.println("RESULT :-  " + result);

	}

}
