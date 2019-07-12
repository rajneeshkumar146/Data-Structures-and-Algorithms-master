package DP;

public class LongestIncreasingSubsequence_tab {

	public static void main(String[] args) {

		int[] arr = new int[] { 10, 22, 9, 33, 21, 50, 41, 60, 80, 1 };

		func(arr);

	}

	public static void func(int[] arr) {

		int[] lis = new int[arr.length];

		String[] subs = new String[arr.length];

		lis[0] = 1;
		subs[0] = arr[0] + " ";

		int max_lis = -1;

		String max_lis_path = "";

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j <= i - 1; j++) {

				if (arr[j] < arr[i]) {
					if (lis[j] > lis[i]) {
						lis[i] = lis[j];
						subs[i] = subs[j];
					}

				}

			}

			lis[i] += 1;
			subs[i] += arr[i] + " ";

			if (max_lis < lis[i]) {
				max_lis = lis[i];
				max_lis_path = subs[i];
			}
		}

		System.out.println(max_lis + " :- " + max_lis_path);
	}
}
