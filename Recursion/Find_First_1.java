package Recursion;

public class Find_First_1 {

	public static void main(String[] args) {
		int arr[] = { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 };

		System.out.println(func(arr) + 1);

	}

	public static int func(int[] arr) {

		if (arr[0] == 1)
			return 0;
		else
			return func(arr, 0, arr.length);
	}

	public static int func(int[] arr, int lo, int hi) {

		int mid = (lo + hi) / 2;

		if (lo == hi && arr[lo] == 0) {
			return lo;
		}

		if (arr[mid] == 0) {
			return func(arr, mid + 1, hi);
		} else if (arr[mid] == 1) {
			return func(arr, lo, mid - 1);
		}

		return -1;

	}

}
