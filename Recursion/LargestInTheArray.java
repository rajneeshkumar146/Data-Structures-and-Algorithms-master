package Recursion;

public class LargestInTheArray {

	public static int LIR(int[] arr, int idx) {

		if (idx == arr.length - 1) {
			return arr[idx];
		}

		int max = LIR(arr, idx + 1);

		if (max > arr[idx]) {
			return max;
		} else {
			return arr[idx];
		}

	}

	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 4, 5, 6, 8, 5, 109, 6, 8, 5, 64, 64, 62, 6, 26, 26, 4, 64, 32, 65, 49, 49, 62, 64, 95, 2, 6,
				95, 6, 23, 9, 9, 9 };

		System.out.println(LIR(a, 0));

	}

}
