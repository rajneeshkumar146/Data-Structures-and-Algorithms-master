package Recursion;

import java.util.ArrayList;

public class TargetSetSS_AL {

	static int sum = 0;

	public static void TargetSetSS_AL(int[] arr, int tar, int idx, ArrayList<Integer> ssf) {

		if (idx >= arr.length) {
			
			if (sum == tar)
			{
				System.out.println(ssf);
			}
			return;
		}

		TargetSetSS_AL(arr, tar, idx + 1, ssf);

		sum += arr[idx];

		ssf.add(arr[idx]);

		TargetSetSS_AL(arr, tar, idx + 1, ssf);

		sum -= arr[idx];

		ssf.remove(ssf.size() - 1);

	}

	public static void main(String[] args) {

		int[] arr = { 10, 20, 30, 40, 50, -5, 5 };

		int tar = 50;

		TargetSetSS_AL(arr, tar, 0, new ArrayList<>());

		// TODO Auto-generated method stub

	}

}
