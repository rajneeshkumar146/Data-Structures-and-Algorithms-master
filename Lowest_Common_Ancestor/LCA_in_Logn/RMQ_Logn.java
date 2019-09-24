package LCA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RMQ_Logn {
	final int mod = 1000000000 + 7;
	public static Scanner scn = new Scanner(System.in);

	private static ArrayList<Integer>[] tree;
	private static int[] Euler;
	private static int[] Level;
	private static int[] Occurence;
	private static int EulerTraversal;

	private static Pair[] SegmentT;

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int n = 8;
		Intialization(n);

		dfs(1, 0);
		construction(0, EulerTraversal - 1, 0);

		// Query.
		System.out.println(Query(6, 7)); // 1.
		System.out.println(Query(6, 4));// 2.
		System.out.println(Query(7, 8));// 3.

		// Check.
		// displayArray(ST);
		// displayArray(Euler);
		// displayArray(Level);
		// displayArray(Occurence);
		// System.out.println(EulerTraversal);

	}

	private static void dfs(int u, int depth) {
		if (Occurence[u] == -1) {
			Occurence[u] = EulerTraversal;
		}

		for (Integer i : tree[u]) {
			Euler[EulerTraversal] = u;
			Level[EulerTraversal++] = depth;
			dfs(i, depth + 1);
		}

		Euler[EulerTraversal] = u;
		Level[EulerTraversal++] = depth;
	}

	private static class Pair {
		int value;
		int index;

		public Pair(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}

	private static Pair construction(int si, int ei, int i) {
		if (si == ei) {
			SegmentT[i] = new Pair(Level[si], si);
			return SegmentT[i];
		}

		int mid = (si + ei) >> 1;
		int a = construction(si, mid, 2 * i + 1).value;
		int b = construction(mid + 1, ei, 2 * i + 2).value;

		SegmentT[i] = a < b ? SegmentT[2 * i + 1] : SegmentT[2 * i + 2];
		return SegmentT[i];
	}

	private static int Query(int lo, int hi) {
		if (hi < lo) {
			int temp = lo;
			lo = hi;
			hi = temp;
		}

		lo = Occurence[lo];
		hi = Occurence[hi];
		Pair ans = Query(lo, hi, 0, EulerTraversal - 1, 0);
		return Euler[ans.index];

	}

	private static Pair Query(int lo, int hi, int si, int ei, int i) {
		if (lo <= si && ei <= hi) {
			return SegmentT[i];
		} else if (hi < si || ei < lo) {
			return new Pair(Integer.MAX_VALUE, -1);
		} else {
			int mid = (si + ei) >> 1;
			Pair a = Query(lo, hi, si, mid, 2 * i + 1);
			Pair b = Query(lo, hi, mid + 1, ei, 2 * i + 2);

			return a.value < b.value ? a : b;

		}
	}

	private static void Intialization(int n) {
		// Tree Section.
		tree = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}

		Euler = new int[2 * n - 1];
		Level = new int[2 * n - 1];
		EulerTraversal = 0;

		Occurence = new int[n + 1];
		Arrays.fill(Occurence, -1);

		// Segment Tree.
		int height = log(n);
		int size = 2 * (int) Math.pow(2, height + 1) - 1;
		SegmentT = new Pair[size];

		// Inputs.
		addEdge(1, 2);
		addEdge(1, 3);
		addEdge(2, 4);
		addEdge(2, 5);
		addEdge(2, 6);
		addEdge(3, 7);
		addEdge(3, 8);

	}

	private static int log(int value) {
		int res = 0;
		while ((1 << res) < value) {
			res++;
		}

		if ((1 << res) > value) {
			res--;
		}
		return res;
	}

	public static void addEdge(int u, int v) {
		tree[u].add(v);
	}

	private static void displayArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
