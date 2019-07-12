package Sorting;

public class Bubblesort_Rcn {

	public static void bbs(int[] arr, int si, int li) {

		if (li == 0) {
			return;

		}

		if (si == li) {
			bbs(arr, 0, li - 1);
			return;
		}

		if (arr[si] > arr[si + 1]) {

			swap(arr, si);
		}

		bbs(arr, si + 1, li);

	}

	public static void swap(int[] arr, int i) {
		int temp = arr[i];

		arr[i] = arr[i + 1];

		arr[i + 1] = temp;

	}

	public static void main(String[] args) {
		int[] arr = { -1, -2, 5, 6, 8, 5, 3, 2, 3, 9, 4, 2, 8, 49, 32, 13 };

		bbs(arr, 0, arr.length - 1);

		for (int var : arr) {

			System.out.print(var + " ");

		}

	}
}
