package Recursion;

public class NextGreater {

	public static void main(String[] args) {

		int arr[] = { -4, 5, 25, 13, 6, 12 };

		func(arr);
	}

	private static void func(int[] arr) {

		int ans[] = new int[arr.length];

		ans[arr.length - 1] = -1;

		int max = arr[arr.length - 1];

		for (int i = arr.length - 2; i >= 0; i--) {

			if (max > arr[i]) {
				ans[i] = max;
			} else {
				ans[i] = -1;
				max = arr[i];
			}

		}

		for (int val : ans) {
			System.out.print(val + " ");
		}

	}

}
