package RangeQuery.SegmentTree_Lazzy.SegmentTree_Basic;

import java.util.Scanner;

public class ST001_RQPU {
	public static Scanner scn = new Scanner(System.in);

	private static int size = 0;
	private static int[] tree;

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int[] arr = { 1, 3, 5, 7, 9, 11 };
		int n = arr.length;

		segmentTree(arr, n);
		construction(arr, 0, n - 1, 0);

	}

	public static void segmentTree(int[] arr, int n) {
		int height = logBase2(n, false);
		size = (1 << (height + 1));

		arr = new int[size];

	}

	private static int construction(int[] arr, int u, int v, int idx) {
		if (u == v) {
			tree[u] = arr[u];
			return tree[u];
		}

		int mid = (u + v) >> 1;
		tree[mid] = construction(arr, u, mid, (idx << 1) + 1) + construction(arr, mid + 1, v, (idx << 1) + 2);
		return tree[mid];

	}

	private static int logBase2(int n, boolean floor) {
		int log = 0;

		while ((1 << log) < n) {
			log++;
		}

		if (floor && (1 << log) > n) {
			log--;
		}

		return log;
	}

}
