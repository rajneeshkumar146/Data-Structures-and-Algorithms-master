package Recursion;

import java.util.ArrayList;

public class SplitArrayinto2EqualSubArray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 5 };
		System.out.println(func(arr));
	}

	public static ArrayList<ArrayList<Integer>> func(int[] arr) {

		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

		int l = 0;
		int lsum = 0;
		int r = arr.length - 1;
		int rsum = 0;

		lsum = arr[l];
		rsum = arr[r];

		while (r - l != 1) {

			if (lsum == rsum) {
				l++;
				r--;
				lsum += arr[l];
				rsum += arr[r];
			} else if (lsum < rsum) {
				l++;
				lsum += arr[l];
			} else {
				r--;
				rsum += arr[r];
			}

		}

		if (lsum == rsum) {
			ArrayList<Integer> lsumer = new ArrayList<Integer>();
			for (int i = 0; i <= l; i++) {
				lsumer.add(arr[i]);
			}
			ArrayList<Integer> rsumer = new ArrayList<Integer>();
			for (int i = r; i <= arr.length - 1; i++) {
				rsumer.add(arr[i]);
			}
			ans.add(lsumer);
			ans.add(rsumer);

			return ans;
		} else {
			return ans;
		}
	}
}
