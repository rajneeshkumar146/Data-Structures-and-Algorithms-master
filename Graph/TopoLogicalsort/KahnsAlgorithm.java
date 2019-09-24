package Graphs.TopoLogicalsort;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class KahnsAlgorithm {
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

		KahnsAlgo();

	}

	private static void KahnsAlgo() {

		HashMap<String, Integer> indegree = new HashMap<>();
		LinkedList<String> stack = new LinkedList<>();
		LinkedList<String> res = new LinkedList<>(); // Shoud_Add_Like_A_Queue.

		// Compute_Indegree_of_all_the_nodes.
		for (String keys : graph.keySet()) {
			for (String key : graph.get(keys)) {
				indegree.put(key, indegree.containsKey(key) ? indegree.get(key) + 1 : 1);
			}

			if (!indegree.containsKey(keys)) { // For_Those_whose_indegree_is_zero_so_it_not_occure_inSecond_Loop.
				indegree.put(keys, 0);
			}
		}

		// Put_all_vertex_in_stack_whose_indegree_is_zero.
		for (String key : indegree.keySet()) {
			if (indegree.get(key) == 0) {
				stack.addFirst(key);
			}
		}

		int count = 0;
		while (!stack.isEmpty()) {
			// Remove.
			String process = stack.removeFirst();

			// addInResult.
			res.addLast(process);

			for (String key : graph.get(process)) {
				indegree.put(key, indegree.get(key) - 1);
				if (indegree.get(key) == 0) {
					stack.addLast(key);
				}

				count++;
			}
		}

		if (graph.size() != count) {
			System.out.println("Not Possible TopoSort");
			return;
		}

		System.out.println(res);

	}

}
