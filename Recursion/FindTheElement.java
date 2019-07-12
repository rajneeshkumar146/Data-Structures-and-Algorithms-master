package Recursion;

public class FindTheElement {

	public static void FTH(int[] arr, int n, int idx) {

		if (idx == arr.length - 1) {
			return;
		}

		if (arr[idx] == n) {
			System.out.println("Found at index " + (idx + 1) + " Number " + arr[idx]);
		}

		FTH(arr, n, idx + 1);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 1, 2, 4, 7, 5, 6, 8 };

		FTH(arr, 7, 0);

	}

}
