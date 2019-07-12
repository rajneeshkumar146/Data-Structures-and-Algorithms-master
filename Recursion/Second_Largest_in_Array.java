package Recursion;

public class Second_Largest_in_Array {
	public static void main(String[] args) {
		int arr[] = { 12, 35, 1, 10, 34, 1 };
		second_smallest(arr);
	}

	private static void second_smallest(int[] arr) {

		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > first) {
				second = first;
				first = arr[i];
			} else if (arr[i] < first && arr[i] > second) {
				second = arr[i];
			}

		}

		System.out.println(second);

	}
}
