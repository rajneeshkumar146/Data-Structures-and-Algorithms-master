package Recursion;

public class Flip_0s {

	public static void main(String[] args) {

		int arr[] = { 0, 1, 0, 0, 1, 1, 0 };

		for (int val : arr) {
			System.out.print(val + " ");
		}

		System.out.println();

		func(arr);

	}

	public static void func(int arr[]) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				arr[i] = -1;
			}
		}

		for (int val : arr) {
			System.out.print(val + " ");
		}

		int sum = arr[0];

		int s = 0;
		int e = 0;

		int max = 0;
		int sp = 0;
		int ep = 0;

		for (int i = 0; i < arr.length; i++) {

			if (sum > 0) {
				sum += arr[i];
				e++;
			} else {
				sum = arr[i];
				s = e = i;
			}

			if (max < sum) {
				max = sum;
				sp = s;
				ep = e;
			}

		}

		System.out.println();

		for (int i = 0; i < arr.length; i++) {
			if (i == sp || i == ep) {
				arr[i] = 0;
			}

			if (arr[i] == -1) {
				arr[i] = 0;
			}
		}

		for (int val : arr) {
			System.out.print(val + " ");
		}

		System.out.println("By Flipping " + sp + " " + ep);
	}

}
