package Sorting;

public class InsertionSort {

	public static void iss(int[] arr) {

		int jc = 1;

		while (jc < arr.length - 1) {

			for (int i = jc; i > 0; i--) {
				if (arr[i] < arr[i - 1]) {
					swap(arr, i);
				} else {

					break;

				}
			}
			jc++;

		}

	}

	public static void swap(int arr[], int i) {

		int temp = arr[i];

		arr[i] = arr[i - 1];

		arr[i - 1] = temp;

	}

	public static void main(String[] args) {

		int[] a = { -1, 10, 5, 3, 2, 7, 8 };

		iss(a);

		for (int var : a) {

			System.out.print(var + " ");

		}
	}
}
