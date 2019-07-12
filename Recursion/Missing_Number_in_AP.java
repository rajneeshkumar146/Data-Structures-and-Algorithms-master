package Recursion;

public class Missing_Number_in_AP {

	public static void main(String[] args) {

		int arr[] = { 2, 4, 8, 10, 12, 14 };
		int n = arr.length;

		System.out.println(ApFind(arr, n));

	}

	public static int ApFind(int[] arr, int n) {

		int find = (arr[n - 1] + arr[0]) / n;

		return ApFind(arr, 0, n - 1, find);

	}

	private static int ApFind(int[] arr, int lo, int hi, int diff) {

		if (hi <= lo)
			return Integer.MAX_VALUE;

		int mid = (lo + hi) / 2;

		if (arr[mid + 1] - arr[mid] != diff) {
			return (arr[mid] + diff);
		}

		if (mid > 0 && arr[mid] - arr[mid - 1] != diff) {
			return (arr[mid - 1] + diff);
		}

		if (arr[mid] == arr[0] + mid * diff) {
			return (ApFind(arr, mid + 1, hi, diff));
		}

		return (ApFind(arr, lo, mid - 1, diff));
	}
}
