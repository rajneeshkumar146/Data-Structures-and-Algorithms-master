package RangeQuery.IndexTree;

import java.util.Scanner;

public class RangeUpdatePointQuery {
	final int mod = 1000000000 + 7;
	public static Scanner scn = new Scanner(System.in);

	private static int size;
	private static int[] ftree;

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		// int n = scn.nextInt();
		// int[] arr = ArrayInput(n);
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int n = arr.length;

		fenwickTree(arr, n);
		displayArray(ftree);
		System.out.printf("%d\n", query(2));
		// RangeUpdate(2, 2, 4);
		// System.out.printf("%d\n", query(4));
		// RangeUpdate(4, 0, 3);
		// System.out.printf("%d\n", query(3));

	}

	public static void fenwickTree(int[] arr, int n) {
		size = n + 1;
		ftree = new int[size];

		for (int i = 0; i < n; i++) {
			RangeUpdate(arr[i], i, i);
		}

	}

	private static long query(int index) {
		index++;
		long sum = 0;
		while (index > 0) {
			sum += ftree[index];
			index -= (index & (-index));
		}

		return sum;
	}

	public static void RangeUpdate(int data, int si, int ei) {
		update(data, si);
		update(-data, ei + 1);

	}

	public static void update(int data, int index) {
		index++;
		while (index < size) {
			ftree[index] += data;
			index += (index & (-index));
		}
	}

	private static void displayArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	private static int[] ArrayInput(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}

}
