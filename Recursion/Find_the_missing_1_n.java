package Recursion;

public class Find_the_missing_1_n {

	public static void main(String[] args) {

		int[] arr = { 10, 1, 9, 2, 8, 3, 7, 5, 4 };

		funcSum(arr);

		int arrSorted[] = { 1, 2, 3, 4, 5, 7, 8 };
		System.out.println(funcLogNSorted(arrSorted));

	}

	private static void FuncXor(int[] arr) {

		int x1 = arr[0];

		for (int i = 1; i < arr.length; i++) {
			x1 = x1 ^ arr[i];
		}
		int x2 = 1;

		for (int i = 2; i <= arr.length + 1; i++) {
			x2 = x2 ^ i;
		}

		System.out.println(x1 ^ x2);
	}

	public static void funcSum(int[] arr) {
		int n = arr.length;

		int sum = (n + 1) * (n + 2) / 2;

		for (int i = 0; i < arr.length; i++) {
			sum -= arr[i];
		}

		System.out.println(sum);
	}

	public static int funcLogNSorted(int[] arr) {

		int low = 0;
		int high = arr.length - 1;

		while (high >= low) {

			int mid = (low + high) / 2;

			if (arr[mid] != mid + 1 && arr[mid - 1] == mid) {
				return (mid + 1);
			}
			if (arr[mid] != mid + 1) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}

		return -1;

	}

}