package Recursion;

public class ZigZag_Array {

	public static void main(String[] args) {

		int arr[] = new int[] { 4, 3, 7, 8, 6, 2, 1 };

		zigzag(arr);

		for (int val : arr) {
			System.out.print(val + " ");
		}

	}

	public static void zigzag(int[] arr) {

		int ctr = 0;

		while (arr.length - 2 > ctr) {
			if (ctr % 2 == 0) {
				if (arr[ctr] > arr[ctr + 1]) {
					swap(arr, ctr);
				}
			} else {
				if (arr[ctr + 1] > arr[ctr]) {
					swap(arr, ctr);
				}
			}
			ctr++;
		}
	}

	private static void swap(int[] arr, int i) {

		int temp = arr[i];

		arr[i] = arr[i + 1];

		arr[i + 1] = temp;

	}
}
