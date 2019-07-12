package Sorting;

public class SelectionSort {

	public static void sls(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {

				if (arr[i] > arr[j]) {

					swap(arr, i, j);

				}

			}
		}

	}

	public static void swap(int[] arr, int i, int j) {

		int temp = arr[i];

		arr[i] = arr[j];

		arr[j] = temp;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = { -1, 10, 5, 3, 2, 7, 8 };

		sls(a);

		for (int var : a) {

			System.out.print("  " + var + "  ");

		}

	}

}
