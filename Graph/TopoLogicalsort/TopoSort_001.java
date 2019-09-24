package Graphs.TopoLogicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class TopoSort_001 {
	public static Scanner scn = new Scanner(System.in);

	private static HashMap<String, HashSet<String>> graph = new HashMap<String, HashSet<String>>();

	public static void main(String[] args) throws Exception {
		UsingHashMap();
	}

	// UsingHashMap.==========================================================================================

	public static void UsingHashMap() {
		// Graph1-----------------------------------------------------------------------------------------------------------

		graph.put("A", new HashSet<String>());
		graph.put("B", new HashSet<String>());
		graph.put("C", new HashSet<String>());
		graph.put("D", new HashSet<String>());
		graph.put("E", new HashSet<String>());
		graph.put("F", new HashSet<String>());

		graph.get("A").add("C");
		graph.get("A").add("F");
		graph.get("B").add("F");
		graph.get("B").add("E");
		graph.get("D").add("E");
		graph.get("C").add("D");
		// graph.get("D").add("F");

		// Graph2-----------------------------------------------------------------------------------------------------------

		// graph.put("0", new HashSet<String>());
		// graph.put("1", new HashSet<String>());
		// graph.put("2", new HashSet<String>());
		// graph.put("3", new HashSet<String>());
		// graph.put("4", new HashSet<String>());
		// graph.put("5", new HashSet<String>());
		//
		// graph.get("0").add("1");
		// graph.get("0").add("3");
		// graph.get("1").add("2");
		// graph.get("1").add("3");
		// graph.get("2").add("4");
		// graph.get("2").add("3");
		// graph.get("2").add("5");
		// graph.get("4").add("5");
		// graph.get("3").add("4");
		// graph.get("3").add("5");

		// Graph3-----------------------------------------------------------------------------------------------------------

		// int n = scn.nextInt();
		//
		// for (int i = 1; i < n; i++) {
		// String x = scn.next();
		// String y = scn.next();
		// if (!graph.containsKey(x)) {
		// graph.put(x, new HashSet<String>());
		// }
		// graph.get(x).add(y);
		// }

		TopoSortRecu();
		TopologicalSortIr();
	}

	private static void TopoSortRecu() {
		HashSet<String> isdone = new HashSet<>();
		LinkedList<String> stack = new LinkedList<>();

		for (String key : graph.keySet()) {
			if (isdone.contains(key)) {
				continue;
			}
			TopoSortRecu(key, isdone, stack);
		}

		System.out.println(stack);
	}

	private static void TopoSortRecu(String src, HashSet<String> isdone, LinkedList<String> stack) {

		isdone.add(src);
		if (graph.containsKey(src)) {
			ArrayList<String> keys = new ArrayList<>(graph.get(src));
			for (String key : keys) {
				if (isdone.contains(key)) {
					continue;
				}

				TopoSortRecu(key, isdone, stack);
			}
		}
		stack.addFirst(src);
	}

	// IterativeTopoSort.=======================================================================================

	private static class Pair {
		private String vtx;
		private int acdone; // AllChildDone.

		public Pair(String vtx, int acdone) {
			this.vtx = vtx;
			this.acdone = acdone;
		}
	}

	public static void TopologicalSortIr() {
		LinkedList<String> res = new LinkedList<>();
		HashSet<String> isdone = new HashSet<>();
		LinkedList<Pair> stack = new LinkedList<>();

		for (String vce : graph.keySet()) {
			if (isdone.contains(vce)) {
				continue;
			}

			stack.addFirst(new Pair(vce, graph.get(vce).size()));

			while (!stack.isEmpty()) {
				// Peek.
				Pair process = stack.getFirst();

				// Mark.
				isdone.add(process.vtx);

				// Check_Vertex_Without_Any_child.
				if (!graph.containsKey(process.vtx)) {
					res.addFirst(process.vtx);
					stack.removeFirst();
				}

				if (process.acdone > 0) { // Process_all_childs.
					ArrayList<String> keys = new ArrayList<>(graph.get(process.vtx));
					for (String key : keys) {
						process.acdone -= 1; // LoopMai_ane_ka_matlb_ek_child_process_hpgya.

						if (isdone.contains(key)) {
							continue;
						}

						stack.addFirst(new Pair(key, graph.get(key).size()));
						break; // EkBaarMai_ek_child.
					}
				} else { // PostOder
					res.addFirst(process.vtx);
					stack.removeFirst();
				}
			}

		}

		System.out.println(res);

	}

	// UsingMatrix.=============================================================================================

	public static void UsingMatrix() {
		// 6 10 0 1 0 3 1 2 1 3 2 3 2 4 2 5 3 4 3 5 4 5

		int n = scn.nextInt();
		int m = scn.nextInt();
		boolean[][] graph = new boolean[n][n];
		for (int i = 1; i <= m; i++) {
			graph[scn.nextInt()][scn.nextInt()] = true;
		}

	}

	public static void TopoSortRecuMatrix(boolean[][] graph) {
		boolean[] isdone = new boolean[graph.length];
		LinkedList<Integer> stack = new LinkedList<>();

		for (int vtx = 0; vtx < graph.length; vtx++) {
			if (isdone[vtx]) {
				continue;
			}
			TopoSortRecuMatrix(vtx, graph, isdone, stack);
		}

		System.out.println(stack);
	}

	private static void TopoSortRecuMatrix(int src, boolean[][] graph, boolean[] isdone, LinkedList<Integer> stack) {

		isdone[src] = true;
		for (int nbr = 0; nbr < graph[src].length; nbr++) {
			if (isdone[nbr]) {
				continue;
			}
			TopoSortRecuMatrix(nbr, graph, isdone, stack);
		}
		stack.add(src);
	}

}
