
package Graphs.Kruskal_Edge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Kruskal_byEdge {
	public static Scanner scn = new Scanner(System.in);

	private static ArrayList<Edge> map = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

		map.add(new Edge("A", "B", 10));
		map.add(new Edge("A", "D", 40));
		map.add(new Edge("B", "C", 10));
		map.add(new Edge("C", "D", 10));
		map.add(new Edge("D", "E", 2));
		map.add(new Edge("E", "F", 2));
		map.add(new Edge("F", "G", 3));
		map.add(new Edge("E", "G", 8));

		kruskal();

	}

	// UsingHashMap.==========================================================================================

	private static class Edge implements Comparable<Edge> {
		private String vtx1;
		private String vtx2;
		private int weight;

		public Edge(String vtx1, String vtx2, int weight) {
			this.vtx1 = vtx1;
			this.vtx2 = vtx2;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "(" + this.vtx1 + ", " + this.vtx2 + ") -> " + this.weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	private static class Cluster {
		private String parent;
		private int size;

		private Cluster(String parent, int size) {
			this.parent = parent;
			this.size = size;
		}

		@Override
		public String toString() {
			return "(" + this.parent + ", " + this.size + ")";
		}

	}

	private static String Find(HashMap<String, Cluster> DisjointSet, String vtx) {

		Cluster c = DisjointSet.get(vtx);
		if (c.parent.equals(vtx)) {
			return vtx;
		} else {
			c.parent = Find(DisjointSet, c.parent);
			return c.parent;
		}

	}

	private static void Union(Cluster leader1, Cluster leader2) {
		if (leader1.size < leader2.size) {
			leader2.size += leader1.size;
			leader1.parent = leader2.parent;
			leader1.size = -1;
		} else {

			leader1.size += leader2.size;
			leader2.parent = leader1.parent;
			leader2.size = -1;
		}

	}

	private static void kruskal() {
		ArrayList<Edge> graph = new ArrayList<>();
		PriorityQueue<Edge> heap = new PriorityQueue<>();
		HashMap<String, Cluster> DisjointSet = new HashMap<>();

		// disjointSet_And_Heap_arePopulated.
		for (Edge vce : map) {
			heap.add(vce);

			DisjointSet.put(vce.vtx1, new Cluster(vce.vtx1, 1));
			DisjointSet.put(vce.vtx2, new Cluster(vce.vtx2, 1));
		}

		while (!heap.isEmpty()) {
			Edge process = heap.remove();

			String leader1 = Find(DisjointSet, process.vtx1);
			String leader2 = Find(DisjointSet, process.vtx2);

			if (!leader1.equals(leader2)) {
				Union(DisjointSet.get(leader1), DisjointSet.get(leader2));
				graph.add(process);
			}

		}
		
		System.out.println(graph);

	}

	// UsingArray.==========================================================================================

}
