package Graph;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Graph_Matrix {
	static Integer[][] graph = new Integer[7][7];

	public static void main(String[] args) {

		addEdge(0, 1, 10);
		addEdge(1, 2, 10);
		addEdge(2, 3, 10);
		addEdge(0, 3, 40);
		addEdge(3, 4, 2);
		addEdge(4, 5, 3);
		addEdge(5, 6, 3);
		addEdge(4, 6, 8);
		addEdge(2, 5, 20);

		System.out.println(hashPath(graph, 0, 6));
		System.out.println();
		allPath(graph, 0, 6);

		spd = Integer.MAX_VALUE;
		sp = "";

		lpd = Integer.MIN_VALUE;
		lp = "";

		cpd = Integer.MAX_VALUE;
		cp = "";

		fpd = Integer.MIN_VALUE;
		fp = "";

		System.out.println();

		hamiltonianPnC(2);

		multiSolver(graph, 0, 6, 0, 40, 50, 3);

		System.out.println(spd + "@" + sp);
		System.out.println(lpd + "@" + lp);
		System.out.println(fpd + "@" + fp);

	}

	public static void addEdge(int s, int d, int wt) {

		graph[s][d] = wt;

		graph[d][s] = wt;

	}

	private static boolean hashPath(Integer[][] graph, int s, int d) {

		HashSet<Integer> visited = new HashSet<Integer>();

		visited.add(s);

		return hashPath(graph, s, d, visited);

	}

	public static boolean hashPath(Integer[][] graph, int s, int d, HashSet<Integer> visited) {

		if (s == d) {
			return true;
		}

		for (int i = 0; i < graph.length; i++) {

			if ((graph[s][i] != null) && (visited.contains(i) == false)) {

				visited.add(i);

				boolean ans = hashPath(graph, i, d, visited);
				if (ans) {

					return true;

				}

			}
		}

		return false;

	}

	public static void allPath(Integer[][] graph, int s, int d) {

		HashSet<Integer> visited = new HashSet<Integer>();

		visited.add(s);

		allPath(graph, s, d, visited, new String());

	}

	private static void allPath(Integer[][] graph, int s, int d, HashSet<Integer> visited, String path) {
		if (s == d) {
			System.out.println(path + d);
			return;
		}

		for (int i = 0; i < graph.length; i++) {
			if ((graph[s][i] != null) && (visited.contains(i) == false)) {

				visited.add(i);

				allPath(graph, i, d, visited, path + s + " ");

				visited.remove(i);
			}
		}

	}

	public static void multiSolver(Integer[][] graph, int s, int d, int dsf, int cw, int fw, int k) {

		HashSet<Integer> visited = new HashSet<Integer>();

		visited.add(s);

		multiSolver(graph, s, d, new HashSet<>(), new String(), dsf, cw, fw, k);

	}

	static int spd;
	static String sp;

	static int lpd;
	static String lp;

	static int cpd;
	static String cp;

	static int fpd;
	static String fp;

	static PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());

	public static class Pair implements Comparable<Pair> {

		int dest;
		String path;

		Pair(int dest, String path) {
			this.dest = dest;
			this.path = path;
		}

		@Override
		public int compareTo(Pair o) {
			return this.dest - o.dest;
		}

		@Override
		public String toString() {
			return (path + " @ " + dest);
		}

	}

	private static void multiSolver(Integer[][] graph, int s, int d, HashSet<Integer> visited, String path, int dsf,
			int cw, int fw, int k) {

		if (s == d) {

			path += d;

			if (path.length() < spd) {
				spd = path.length();
				sp = path;
			}

			if (path.length() > lpd) {
				lpd = path.length();
				lp = path;
			}

			if (path.length() < cw && dsf > cpd) {
				cpd = dsf;
				cp = path;

			}

			if (path.length() > fw && dsf < fpd) {

				fpd = dsf;
				fp = path;
			}

			if (k > pq.size()) {
				Pair pair2 = new Pair(dsf, path);

				pq.add(pair2);
			} else {
				if (pq.peek().dest > path.length()) {
					Pair pair = new Pair(path.length(), path);

					pq.remove();

					pq.add(pair);

				}
			}
			return;

		}

		for (int i = 0; i < graph.length; i++) {
			if ((graph[s][i] != null) && (visited.contains(i) == false)) {

				visited.add(i);

				dsf += graph[s][i];

				multiSolver(graph, i, d, visited, path + s + " ", dsf, cw, fw, k);

				visited.remove(i);
			}
		}

	}

	public static void hamiltonianPnC(int s) {
		HashSet<Integer> visited = new HashSet<Integer>();

		visited.add(s);

		hamiltonianPnC(s, s, visited, s + " ");

	}

	private static void hamiltonianPnC(int s, int os, HashSet<Integer> visited, String path) {

		if ((graph.length) == visited.size()) {
			System.out.println(path);
			System.out.println();

			if (graph[s][os] != null) {
				System.out.println("CYCLE :-" + path);
				System.out.println();
			}
		}

		for (int i = 0; i < graph.length; i++) {
			if ((graph[s][i] != null) && (visited.contains(i) == false)) {

				visited.add(i);

				hamiltonianPnC(i, os, visited, path + i + " ");

				visited.remove(i);

			}
		}

	}

}
