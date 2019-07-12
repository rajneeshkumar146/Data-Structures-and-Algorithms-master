package Recursion;

public class MaxOnTheRight {

	public static void main(String[] args) {
		int arr[] = { 16, 17, 4, 3, 5, 2 };

		printArray(arr);

		func(arr);

		System.out.println();

		printArray(arr);

	}

	public static void func(int[] arr) {

		int maxR = arr[arr.length - 1];

		arr[arr.length - 1] = -1;

		for (int i = arr.length - 2; i >= 0; i--) {

			int temp = arr[i];

			arr[i] = maxR;

			maxR = Math.max(maxR, temp);

		}
	}

	static void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}
