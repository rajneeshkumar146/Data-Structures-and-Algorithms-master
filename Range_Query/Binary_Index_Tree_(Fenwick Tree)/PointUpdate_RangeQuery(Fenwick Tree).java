package RangeQuery.IndexTree;

import java.util.Scanner;

public class PointUpdateRangeQuery {
	public static Scanner scn = new Scanner(System.in);

	private static int size;
	private static long[] ftree;

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		// int n = scn.nextInt();
		// int[] arr = ArrayInput(n);
		int[] arr = { 2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9 };
		int n = arr.length;

		fenwickTree(arr, n);
		System.out.printf("%d \n", query(0, 5));
		update(6, 3);
		System.out.printf("%d \n", query(0, 5));

	}

	public static void fenwickTree(int[] arr, int n) {
		size = n + 1;
		ftree = new long[size];
		for (int i = 0; i < n; i++) {
			update(arr[i], i);
		}
	}

	public static long query(int l, int r) {
		return query(r) - query(l - 1);
	}

	private static long query(int index) {
		index++;
		long sum = 0;
		while (index != 0) {
			sum += ftree[index];
			index -= (index & -index);
		}

		return sum;
	}

	private static void update(int data, int index) {
		index++;
		while (index < size) {
			ftree[index] += data;
			index += (index & -index);
		}
	}

	private static int[] ArrayInput(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}

	private static void displayArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
