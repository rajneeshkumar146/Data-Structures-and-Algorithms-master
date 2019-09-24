package RangeQuery;

import java.util.Scanner;

public class SparseTable {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int[] arr = ArrayInput(scn.nextInt());
		int[][] sparseTable = SparseTable(arr);

	}

	private static int[][] SparseTable(int[] arr) {
		int log = getLog(arr.length);
		int[][] lookup = new int[arr.length][log + 1];

		for (int i = 0; i < lookup.length; i++) {
			lookup[i][0] = i;
		}

		for (int j = 1; j < lookup[0].length; j++) {
			for (int i = 0; i + (1 << j) - 1 < lookup.length; i++) {
				lookup[i][j] = arr[lookup[i][j - 1]] < arr[lookup[i + (1 << (j - 1))][j - 1]] ? lookup[i][j - 1]
						: lookup[i + (1 << (j - 1))][j - 1];
			}
		}

		return lookup;

	}

	private static int Query(int[] arr, int[][] sparseTable, int i, int j) {

		int diff = j - i + 1;
		int log = getLog(diff);

		int min1 = sparseTable[i][log];
		int min2 = sparseTable[j - (1 << log)][j];

		return Math.min(arr[min1], arr[min2]);
	}

	private static int getLog(int n) {
		int log = 0;

		while ((1 << log) < n) {
			log++;
		}

		if ((1 << log) > n) {
			log--;
		}

		return log;
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
