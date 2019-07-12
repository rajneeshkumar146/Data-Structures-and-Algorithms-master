package Recursion;

import java.util.Arrays;

public class Pythagorean_Triplet {

	public static void main(String[] args) {

		int[] arr = { 0, 4, 6, 12, 5 };
		System.out.println(func(arr, arr.length));
	}

	public static boolean func(int[] arr, int n) {
		int zctr = 0;
		for (int i = 0; i < arr.length; i++) {

			arr[i] = arr[i] + arr[i];

			if (arr[i] == 0) {
				zctr++;
			}

		}

		Arrays.sort(arr);

		for (int i = n - 1; i >= 2; i--) {

			int l = zctr;

			int r = n - 1;

			while (r > l) {

				if (arr[l] + arr[r] == arr[i]) {
					System.out.println(arr[r] + " + " + arr[l] + " - > " + arr[i]);
					return true;
				}
				if (arr[l] + arr[r] < arr[i]) {
					l++;
				} else {
					r--;
				}

			}

		}
		return false;
	}

}
