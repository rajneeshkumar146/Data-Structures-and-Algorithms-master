package Recursion;

import java.util.ArrayList;

public class Sum_of_all_possible_SubSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 2, 0, 11, 3, 0 };

		subset(arr, 0, arr.length - 1, 0);
	}

	public static void subset(int[] arr, int lo, int hi, int sum) {

		if (lo > hi) {
			System.out.print(sum + " ");
			return;
		}

		subset(arr, lo + 1, hi, sum + arr[lo]);

		subset(arr, lo + 1, hi, sum);

	}

}
