package Recursion;

//https://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/

public class Sort_0_1 {

	public static void main(String[] args) {

		int[] arr = { 0, 1, 0, 1, 0, 0, 1, 1, 1, 0 };

		func(arr);

		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

	public static void func(int[] arr) {

		int start = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == 0) {

				int temp = arr[i];

				arr[i] = arr[start];

				arr[start] = temp;

				start++;
			}

		}

	}

}
