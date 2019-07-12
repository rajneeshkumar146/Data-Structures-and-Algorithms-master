package Recursion;

public class Find_duplicate_0_n {

	public static void func(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[Math.abs(arr[i])] >= 0) {

				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			} else {
				System.out.print(Math.abs(arr[i]) + " ");
			}
		}

	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 1, 3, 6, 6 };

		func(arr);
	}

}
