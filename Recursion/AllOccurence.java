package Recursion;

public class AllOccurence {

	public static void func(int[] arr, int idx, int n) {

		if (idx == arr.length) {
			return;
		}

		if (arr[idx] == n) {
			System.out.println(idx + 1);
		}

		func(arr, idx + 1, n);

	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 5, 6, 5, 6, 5, 65, 5, 6, 5, 5 };

		func(arr, 0, 5);

	}

}
