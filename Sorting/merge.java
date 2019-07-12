 package Sorting;

public class merge {
	public static void main(String[] args) {

		int[] a = { 10, 20, 30, 40, 50 };

		int[] b = { 11, 15, 22, 27, 37, 57, 67 };

		int[] arr = { 5, 2, 7, 1, 3, 9 };

		int[] mergerd = mergesort(arr, 0, arr.length - 1);

		for (int val : mergerd) {
			System.out.print(val + "  ");
		}

	}

	public static int[] merge(int[] a, int[] b) {

		int i = 0;
		int j = 0;
		int r = 0;

		int[] merge = new int[a.length + b.length];

		while (a.length > i && b.length > j) {

			if (a[i] > b[j]) {

				merge[r] = b[j];
				j++;
				r++;

			} else {

				merge[r] = a[i];

				i++;
				r++;

			}
		}

		while (a.length > i) {

			merge[r] = a[i];

			i++;
			r++;

		}

		while (b.length > j) {

			merge[r] = b[j];

			j++;
			r++;

		}

		return merge;

	}

	public static int[] mergesort(int[] arr, int lo, int hi) {

		if (lo == hi) {

			int[] barr = new int[1];

			barr[0] = arr[lo];

			return barr;
		}

		int mid = (lo + hi) / 2;

		int[] left = mergesort(arr, lo, mid);
		int[] right = mergesort(arr, mid + 1, hi);

		return merge(left, right);
	}

}
