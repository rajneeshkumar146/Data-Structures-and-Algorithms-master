package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class TopologicalSort {

	static HashMap<String, HashSet<String>> graph = new HashMap<String, HashSet<String>>();

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		// Graph1-----------------------------------------------------------------------------------------------------------

		// Vertices
		graph.put("A", new HashSet<String>());
		graph.put("B", new HashSet<String>());
		graph.put("C", new HashSet<String>());
		graph.put("D", new HashSet<String>());
		graph.put("E", new HashSet<String>());
		graph.put("F", new HashSet<String>());

		// edge
		graph.get("A").add("C");
		graph.get("A").add("F");
		graph.get("B").add("F");
		graph.get("B").add("E");
		graph.get("D").add("E");
		graph.get("C").add("D");

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

		TopologicalSort();
		// TopologicalSortArray();
		// TopologicalSortIr();

	}

	// Recursive_Method_Of_HashMap------------------------------------------------------------------------------------------------------------------

	public static void TopologicalSort() {
		LinkedList<String> stack = new LinkedList<String>();
		HashSet<String> isdone = new HashSet<String>();
		ArrayList<String> vnames = new ArrayList<String>(graph.keySet());
		for (String vname : vnames) {
			if (isdone.contains(vname)) {
				continue;
			}

			TopologicalSort(vname, stack, isdone);

		}

		System.out.println(stack);
	}

	private static void TopologicalSort(String vname, LinkedList<String> stack, HashSet<String> isdone) {

		isdone.add(vname);
		if (graph.containsKey(vname)) {
			ArrayList<String> keys = new ArrayList<String>(graph.get(vname));
			for (String key : keys) {
				if (isdone.contains(key)) {
					continue;
				}
				TopologicalSort(key, stack, isdone);
			}
		}

		stack.addFirst(vname);

	}

	// Recusrsive_Method_of_2DArray------------------------------------------------------------------------------------------------------------------

	public static void TopologicalSortArray() {
		// 6 10 0 1 0 3 1 2 1 3 2 3 2 4 2 5 3 4 3 5 4 5

		int n = scn.nextInt();
		int m = scn.nextInt();
		boolean[][] graph = new boolean[n][n];
		for (int i = 1; i <= m; i++) {
			graph[scn.nextInt()][scn.nextInt()] = true;
		}

		boolean[] isdone = new boolean[n];

		LinkedList<Integer> stack = new LinkedList<Integer>();
		for (int row = 0; row < n; row++) {
			if (isdone[row] == true) {
				continue;
			}

			TopologicalSortArray(row, graph, isdone, stack);
		}

		System.out.println(stack);

	}

	private static void TopologicalSortArray(int row, boolean[][] graph, boolean[] isdone, LinkedList<Integer> stack) {

		isdone[row] = true;
		for (int col = 0; col < graph[0].length; col++) { // loop_for_key_that_stored_in_keys_of_that_Vertex.
			if (graph[row][col] == true || isdone[col]) {
				continue;
			}
			TopologicalSortArray(col, graph, isdone, stack);
		}
		stack.addFirst(row);
	}

	// Itreative_Method_Of_HashMap------------------------------------------------------------------------------------------------------------------

	public static void TopologicalSortIr() {
		LinkedList<String> stackRes = new LinkedList<String>();
		LinkedList<StackPair> stack = new LinkedList<StackPair>();
		HashSet<String> isdone = new HashSet<String>();
		ArrayList<String> vnames = new ArrayList<String>(graph.keySet());
		for (String vname : vnames) {
			if (isdone.contains(vname)) {
				continue;
			}

			StackPair st = new StackPair(vname, graph.get(vname).size(), false);
			stack.addFirst(st);
			while (!stack.isEmpty()) {
				StackPair pair = stack.peek();

				ArrayList<String> keys = new ArrayList<String>(graph.get(pair.vtx));
				if (pair.acdone > 0) {
					for (String key : keys) {
						if (!isdone.contains(key)) {
							StackPair np = new StackPair(key, graph.get(key).size(), false);
							pair.acdone -= 1;
							stack.addFirst(np);
							break;
						} else {
							pair.acdone -= 1;
						}
					}
				} else {
					stackRes.addFirst(pair.vtx);
					isdone.add(pair.vtx);
					stack.removeFirst();
				}

			}

		}

		System.out.println(stackRes);

	}

	private static class StackPair {
		private String vtx;
		private int acdone; // allChildDone.
		private boolean selfdone;

		public StackPair(String vtx, int acdone, boolean selfdone) {
			this.vtx = vtx;
			this.acdone = acdone;
			this.selfdone = selfdone;

		}
	}

}
