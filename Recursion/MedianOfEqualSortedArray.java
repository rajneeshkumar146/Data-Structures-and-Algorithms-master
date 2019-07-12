package Recursion;

import java.util.*;

public class MedianOfEqualSortedArray {

	public static void main(String[] args) {

		int ar1[] = { 1, 2, 3, 6 };
		int ar2[] = { 4, 6, 8, 10 };
		int n = ar1.length;
		System.out.println(getMedian(ar1, ar2, n));
	}

	public static int getMedian(int[] ar1, int[] ar2, int n) {

		if (n == 0) {
			return -1;
		} else if (n == 1) {
			return ar1[0];
		} else if (n == 2) {
			return (Math.max(ar1[0], ar2[0]) + Math.min(ar1[1], ar2[1])) / 2;
		}

		int m1 = median(ar1, n);
		int m2 = median(ar2, n);

		if (m1 == m2) {
			return m1;
		} else if (m1 < m2) {

			if (n % 2 == 0) {
				return getMedian(Arrays.copyOfRange(ar1, n / 2 - 1, n), ar2, n - n / 2 + 1);
			}
			return getMedian(Arrays.copyOfRange(ar1, n / 2, n), ar2, n - n / 2);
		} else {

			if (n % 2 == 0) {
				return getMedian(ar1, Arrays.copyOfRange(ar2, n / 2 - 1, n), n - n / 2);
			}
			return getMedian(ar1, Arrays.copyOfRange(ar2, n / 2, n), n - n / 2);

		}

	}

	private static int median(int[] arr, int n) {

		if (n % 2 == 0) {
			return (arr[n / 2 - 1] + arr[n / 2]) / 2;
		}

		return arr[n / 2] / 2;
	}
}
