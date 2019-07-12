package Recursion;

import java.util.*;

public class Random_in_Array {
	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };

		for (int val : arr) {
			System.out.print(val + " ");
		}

		arr = Random(arr, arr.length);

		System.out.println();

		for (int val : arr) {
			System.out.print(val + " ");
		}

	}

	private static int[] Random(int[] arr, int n) {

		Random r = new Random();

		for (int i = n - 1; i > 0; i--) {

			int j = r.nextInt(i + 1);

			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;

		}
		return arr;
	}
}
