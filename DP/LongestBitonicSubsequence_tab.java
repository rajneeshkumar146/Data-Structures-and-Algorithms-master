package DP;

public class LongestBitonicSubsequence_tab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 10, 22, 9, 33, 21, 50, 41, 60, 80, 1 };

		func(arr);

	}

	public static void func(int[] arr) {

		int[] lis = new int[arr.length];
		String[] lisPath = new String[arr.length];

		lis[0] = 1;
		lisPath[0] = arr[0] + " ";

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j <= i - 1; j++) {

				if (arr[j] < arr[i]) {

					if (lis[i] < lis[j]) {

						lis[i] = lis[j];

						lisPath[i] = lisPath[j];
					}

				}

			}

			lis[i] += 1;
			lisPath[i] += arr[i] + " ";
		}

		int[] lds = new int[arr.length];
		String[] ldsPath = new String[arr.length];

		lds[arr.length - 1] = 1;

		ldsPath[arr.length - 1] = arr[arr.length - 1] + " ";

		for (int i = arr.length - 2; i >= 0; i--) {

			for (int j = arr.length - 1; j >= i + 1; j--) {

				if (arr[j] < arr[i]) {
					if (lds[i] < lds[j]) {
						lds[i] = lds[j];
						ldsPath[i] = ldsPath[j];
					}
				}
			}

			lds[i] += 1;
			ldsPath[i] += arr[i] + " ";

		}

		int maxSize = -1;
		String maxPath = "";

		for (int i = 0; i < arr.length; i++) {
			if (lis[i] + lds[i] - 1 > maxSize) {
				maxSize = lis[i] + lds[i] - 1;
				maxPath = lisPath[i] + ldsPath[i].substring(0, ldsPath[i].length() - 4);
			}
		}
		System.out.println(maxSize + " :- " + maxPath);
	}

}
