package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph_AdjacencyLIst {

	public static class Edge {

		int v1;
		int v2;
		int weight;

		Edge(int v1, int v2, int weight) {

			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}
	}

	public static boolean hasEdge(ArrayList<ArrayList<Edge>> Graph, int s, int d) {

		for (int i = 0; i < Graph.get(s).size(); i++) {
			Edge edge = Graph.get(s).get(i);

			if (d == edge.v2) {
				return true;
			}
			if (d == edge.v1) {
				return true;
			}
		}
		return false;

	}

	public static void AddEdge(ArrayList<ArrayList<Edge>> Graph, int v1, int v2, int weight) {

		Graph.get(v1).add(new Edge(v1, v2, weight));

		Graph.get(v2).add(new Edge(v2, v1, weight));

	}

	public static void Display(ArrayList<ArrayList<Edge>> Graph) {

		for (int i = 0; i < Graph.size(); i++) {

		}

	}

	public static boolean HasPath(ArrayList<ArrayList<Edge>> Graph, int s, int d) {

		HashSet<Integer> visited = new HashSet<Integer>();
		visited.add(s);

		return HasPath(Graph, s, d, visited);

	}

	private static boolean HasPath(ArrayList<ArrayList<Edge>> Graph, int s, int d, HashSet<Integer> visited) {

		if (s == d) {
			return true;
		}

		for (int i = 0; i < Graph.get(s).size(); i++) {

			int nbr = Graph.get(s).get(i).v2;

			if (!visited.contains(nbr)) {

				visited.add(nbr);

				if (HasPath(Graph, nbr, d, visited)) {
					return true;
				}

			}
		}
		return false;
	}

	public static void PrintAllPath(ArrayList<ArrayList<Edge>> Graph, int s, int d) {

		HashSet<Integer> visited = new HashSet<Integer>();

		visited.add(s);

		PrintAllPath(Graph, s, d, visited, "" + s);

	}

	private static void PrintAllPath(ArrayList<ArrayList<Edge>> Graph, int s, int d, HashSet<Integer> visited,
			String path) {

		if (s == d) {
			System.out.println(path);
			return;
		}

		for (int i = 0; i < Graph.get(s).size(); i++) {

			int nbr = Graph.get(s).get(i).v2;

			if (!visited.contains(nbr)) {

				visited.add(nbr);

				PrintAllPath(Graph, nbr, d, visited, path + nbr);

				visited.remove(nbr);
			}

		}

	}

	static int min = Integer.MAX_VALUE;
	static String minStr = new String();

	static int max = Integer.MIN_VALUE;
	static String maxStr = new String();

	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	static int kTh = 0;

	public static void MultiSolver(ArrayList<ArrayList<Edge>> Graph, int s, int d, int k) {

		HashSet<Integer> visited = new HashSet<Integer>();

		visited.add(s);

		MultiSolver(Graph, s, d, visited, "" + s, 0, k);

	}

	private static void MultiSolver(ArrayList<ArrayList<Edge>> Graph, int s, int d, HashSet<Integer> visited,
			String path, int w, int k) {

		if (s == d) {

			if (w > max) {
				max = w;
				maxStr = path;
			}

			if (w < min) {
				min = w;
				minStr = path;
			}

			if (pq.size() < k) {
				pq.add(w);
			} else {
				int ctr = 0;
				while ((k - 1) > ctr) {
					pq.remove();
					ctr++;
				}
				kTh = pq.peek();
			}

			return;
		}

		for (int i = 0; i < Graph.get(s).size(); i++) {

			int nbr = Graph.get(s).get(i).v2;

			if (!visited.contains(nbr)) {

				visited.add(nbr);

				MultiSolver(Graph, nbr, d, visited, path + nbr, w + Graph.get(s).get(i).weight, k);

				visited.remove(nbr);

			}

		}

	}

	static int cjs = Integer.MIN_VALUE;
	static String jlStr = new String();

	static int cjl = Integer.MAX_VALUE;
	static String jsStr = new String();

	public static void CeilFloor(ArrayList<ArrayList<Edge>> Graph, int s, int d, int w, int jl, int js, String path) {

		HashSet<Integer> visited = new HashSet<Integer>();

		visited.add(s);

		CeilFloor(Graph, s, d, visited, 0, jl, js, "" + s);

	}

	private static void CeilFloor(ArrayList<ArrayList<Edge>> Graph, int s, int d, HashSet<Integer> visited, int w,
			int jl, int js, String path) {
		if (s == d) {

			if (w > jl && w < cjl) {
				cjl = w;
				jlStr = path;

			}

			if (w < js && w > cjs) {
				cjs = w;
				jsStr = path;
			}

			return;
		}

		for (int i = 0; i < Graph.get(s).size(); i++) {

			int nbr = Graph.get(s).get(i).v2;

			if (!visited.contains(nbr)) {

				visited.add(nbr);

				CeilFloor(Graph, nbr, d, visited, w + Graph.get(s).get(i).weight, jl, js, path + nbr);

				visited.remove(nbr);
			}

		}

	}

	public static void HamitlonaianCycle(ArrayList<ArrayList<Edge>> Graph, int s) {

		HashSet<Integer> visited = new HashSet<Integer>();

		visited.add(s);

		HamitlonaianCycle(Graph, s, visited, s, "" + s);

	}

	private static void HamitlonaianCycle(ArrayList<ArrayList<Edge>> Graph, int s, HashSet<Integer> visited, int os,
			String path) {

		if (visited.size() == Graph.size()) {

			System.out.print("Hamitlonaian Cycle :- " + path);

			if (hasEdge(Graph, s, os)) {
				System.out.println("*");
			} else {
				System.out.println();
			}

		}

		for (int i = 0; i < Graph.get(s).size(); i++) {

			int nbr = Graph.get(s).get(i).v2;

			if (!visited.contains(nbr)) {

				visited.add(nbr);

				HamitlonaianCycle(Graph, nbr, visited, os, path + nbr);

				visited.remove(nbr);

			}

		}

	}

	public static void KnightsTour(int[][] graph, int r, int c, int move) {

		if (r < 0 || r > graph.length || c < 0 || c > graph.length || graph[r][c] == 0) {
			return;
		}

		if (move == graph.length) {
			for (int i = 0; i < graph.length; i++) {
				for (int j = 0; j < graph.length; j++) {
					System.out.print(graph[i][j]);
				}
				System.out.println();
			}
		}

		graph[r][c] = move;

		KnightsTour(graph, r + 2, c + 1, move + 1);
		KnightsTour(graph, r + 2, c + 1, move + 1);
		KnightsTour(graph, r + 2, c + 1, move + 1);
		KnightsTour(graph, r + 2, c + 1, move + 1);
		KnightsTour(graph, r + 2, c + 1, move + 1);
		KnightsTour(graph, r + 2, c + 1, move + 1);
		KnightsTour(graph, r + 2, c + 1, move + 1);
		KnightsTour(graph, r + 2, c + 1, move + 1);

		graph[r][c] = 0;

	}

	private static class Helper {
		int vtx;
		String psf;
		int dsf;

		Helper(int vtx, String psf, int dsf) {

			this.vtx = vtx;
			this.psf = psf;
			this.dsf = dsf;
		}
	}

	public static boolean BFS(ArrayList<ArrayList<Edge>> Graph, int s, int d) {

		LinkedList<Helper> queue = new LinkedList<Helper>();
		HashSet<Helper> visited = new HashSet<Helper>();

		Helper base = new Helper(s, "" + s, 0);

		queue.add(base);

		while (queue.size() > 0) {

			Helper temp = queue.removeFirst();

			System.out.println(temp.vtx + "via" + temp.psf + " " + temp.dsf);

			if (!visited.contains(temp)) {
				continue;
			} else {
				visited.add(temp);
			}

			if (temp.vtx == d) {
				return true;
			}

			for (int i = 0; i < Graph.get(temp.vtx).size(); i++) {

				Edge x = Graph.get(temp.vtx).get(i);
				if (!visited.contains(x.v2)) {
					Helper ch = new Helper(x.v2, temp.psf + x.v2, temp.dsf + x.weight);
					queue.addLast(ch);
				}
			}

		}
		return false;

	}

	public static void main(String[] args) {

		ArrayList<ArrayList<Edge>> Graph = new ArrayList<ArrayList<Edge>>();

		for (int v = 0; v < 7; v++) {
			Graph.add(new ArrayList<Edge>());
		}

		AddEdge(Graph, 0, 1, 10);
		AddEdge(Graph, 1, 2, 10);
		AddEdge(Graph, 2, 3, 10);
		AddEdge(Graph, 0, 3, 40);
		AddEdge(Graph, 3, 4, 2);
		AddEdge(Graph, 4, 5, 3);
		AddEdge(Graph, 4, 6, 8);
		AddEdge(Graph, 5, 6, 3);

		AddEdge(Graph, 2, 5, 10);

		Display(Graph);
		System.out.println();

		System.out.println(HasPath(Graph, 0, 6));
		System.out.println();

		PrintAllPath(Graph, 0, 6);
		System.out.println();

		MultiSolver(Graph, 0, 6, 3);
		System.out.println("Min " + minStr + " @ " + min);
		System.out.println("Max " + maxStr + " @ " + max);
		System.out.println("Kth " + kTh);
		System.out.println();

		CeilFloor(Graph, 0, 6, 0, 52, 52, "");
		System.out.println("Ceil " + jlStr + " @ " + cjl);
		System.out.println("Floor " + jsStr + " @ " + cjs);
		System.out.println();

		HamitlonaianCycle(Graph, 1);

		int[][] mat = new int[5][5];

		KnightsTour(mat, 1, 3, 1);

		System.out.println();

		BFS(Graph, 0, 6);

	}

}
