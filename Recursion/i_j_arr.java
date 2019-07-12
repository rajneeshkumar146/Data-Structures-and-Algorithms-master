package Recursion;

public class i_j_arr {

	public static void main(String[] args) {
		int arr[] = { 9, 2, 3, 4, 5, 6, 7, 8, 18 };
		int n = arr.length;
		System.out.println(maxIndexDiff(arr, n));
	}

	static int maxIndexDiff(int arr[], int n) {
		int maxDiff;
		int i, j;

		int RMax[] = new int[n];
		int LMin[] = new int[n];

		/*
		 * Construct LMin[] such that LMin[i] stores the minimum value from (arr[0],
		 * arr[1], ... arr[i])
		 */
		LMin[0] = arr[0];
		for (i = 1; i < n; ++i)
			LMin[i] = Math.min(arr[i], LMin[i - 1]);

		for (int val : LMin) {
			System.out.print(val + " ");
		}

		System.out.println();

		/*
		 * Construct RMax[] such that RMax[j] stores the maximum value from (arr[n-1],
		 * arr[n-2], ..arr[0])
		 */
		RMax[n - 1] = arr[n - 1];
		for (j = n - 2; j >= 0; --j)
			RMax[j] = Math.max(arr[j], RMax[j + 1]);

		for (int val : RMax) {
			System.out.print(val + " ");
		}

		/*
		 * Traverse both arrays from left to right to find optimum j - i This process is
		 * similar to merge() of MergeSort
		 */
		i = 0;
		j = 0;
		maxDiff = -1;
		while (j < n && i < n) {
			if (LMin[i] < RMax[j]) {
				maxDiff = Math.max(maxDiff, j - i);
				j = j + 1;
			} else
				i = i + 1;
		}
		System.out.println();
		return maxDiff;
	}

}
