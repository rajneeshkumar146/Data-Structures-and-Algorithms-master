package Sorting;

public class BubbleSort_Itr {

	public static void swap(int arr[], int i) {

		int temp = arr[i];

		arr[i] = arr[i + 1];

		arr[i + 1] = temp;

	}

	public static void main(String[] args) {

		int[] a = { -1, 10, 5, 3, 2, 7, 8 };

		int jc = 1;

		while (jc < a.length - 1) {

			for (int i = 0; i < a.length - jc; i++) {

				if (a[i] > a[i + 1]) {

					swap(a, i);

				}

			}

			jc++;
		}

		for (int var : a) {

			System.out.print("  " + var + "  ");

		}

	}

}
