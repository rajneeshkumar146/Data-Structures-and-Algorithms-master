package Recursion;

public class Max_Product_SubArray {

	public static void main(String[] args) {
		int[] arr = { 0, 0, 1, 2, 0, 2, 0, 0, 1, 0, 2, 0, -3, 3, 3, 0, 1, 2, 1 };

		System.out.println(maxProduct(arr));

	}

	public static int maxProduct(int[] A) {

		int ans = A[0];
		int max = A[0];
		int min = A[0];
		for (int i = 1; i < A.length; i++) {
			int temp = max;
			max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
			min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);

			if (max > ans) {
				ans = max;
			}

		}
		return ans;

	}

}
