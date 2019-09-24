package RangeQuery.SegmentTree_Lazzy.SpaceEfficient2n;

import java.util.Scanner;

public class ST001_RQPU {
	public static Scanner scn = new Scanner(System.in);
	private static int[] tree;
	private static int n = 0;

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		n = scn.nextInt();
		tree = new int[(n << 1)];

		// 12 1 2 3 4 5 6 7 8 9 10 11 12
		// insert Leaf or either i say base array elements.
		for (int i = 0; i < n; i++) {
			tree[i + n] = scn.nextInt();
		}

		SegmentTree();
		System.out.println(query(1, 3));
		update(2, 1);
		System.out.println(query(1, 3));

	}

	public static void SegmentTree() {
		// move upward and update parents.
		for (int i = n - 1; i > 0; i--) {
			tree[i] = tree[(i << 1)] + tree[(i << 1) | 1]; //i<<1|1 it add 1.
		}
	}

	public static long query(int u, int v) {
		long sum = 0;
		for (u += n, v += n; u < v; u >>= 1, v >>= 1) {
			sum += ((u & 1) == 1) ? tree[u++] : 0; // odd
			sum += ((v & 1) == 1) ? tree[--v] : 0; // odd
		}

		return sum;
	}

	public static void update(int idx, int data) {
		for (tree[idx += n] = data; idx > 0; idx >>= 1) {
			tree[idx >> 1] = tree[idx] + tree[idx ^ 1]; // idx^1_if_left_know_then_right_dedega_agar_right_pata_hai_to_left_dedega.

		}

	}

}
