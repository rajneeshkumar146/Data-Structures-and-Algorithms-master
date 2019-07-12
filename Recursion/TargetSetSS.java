package Recursion;

public class TargetSetSS {

	public static void TargetSetSS(int[] arr, int tar, int idx, int sum, String ssf) {

		if (idx == arr.length) {

			if (tar == sum) {
				System.out.println(ssf);
			}
			return;
		}

		TargetSetSS(arr, tar, idx + 1, sum, ssf);

		TargetSetSS(arr, tar, idx + 1, sum + arr[idx], ssf + arr[idx] + " ");

	}

	public static void main(String[] args) {

		int[] arr = { 10, 20, 30, 40, 50, -5, 5 };

		int tar = 50;

		TargetSetSS(arr, tar, 0, 0, "");

	}

}
