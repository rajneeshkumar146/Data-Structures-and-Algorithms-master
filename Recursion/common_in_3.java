package Recursion;

import java.util.ArrayList;

public class common_in_3 {

	public static void main(String[] args) {
		int[] arr = { 2, 6, 9, 11, 13, 17 };
		int[] arr1 = { 3, 6, 7, 10, 13, 18 };
		int[] arr2 = { 4, 5, 6, 9, 11, 13 };

		func(arr, arr1, arr2);

	}

	public static void func(int[] arr, int[] arr1, int[] arr2) {

		ArrayList<Integer> ans = new ArrayList<Integer>();

		int x = 0;
		int y = 0;
		int z = 0;

		while ((x < arr.length) && (y < arr1.length) && (z < arr2.length)) {

			if (arr[x] == arr1[y] && arr1[y] == arr2[z]) {

				ans.add(arr[x]);
				x++;
				y++;
				z++;

			} else if (arr[x] < arr1[y]) {
				x++;
			} else if (arr1[y] < arr2[z]) {
				y++;
			} else {
				z++;
			}

		}

		System.out.println(ans);

	}
}
