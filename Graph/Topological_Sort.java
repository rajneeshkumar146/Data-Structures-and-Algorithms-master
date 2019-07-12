package Graph;

import java.util.HashSet;
import java.util.LinkedList;

public class Topological_Sort {

	public static void TopologicalSort(int[][] graph) {

		HashSet visited = new HashSet<>();

		LinkedList<Integer> stack = new LinkedList<>();

		for (int i = 0; i < graph.length; i++) {
			if (visited.contains(i) == false) {

				topologicalSorthelper(graph, i, visited, stack);
			}
		}
		System.out.println(stack);

	}

	private static void topologicalSorthelper(int[][] graph, int src, HashSet<Integer> visited,
			LinkedList<Integer> stack) {

		visited.add(src);

		for (int j = 0; j < graph[src].length; j++) {

			if (visited.contains(j) || graph[src][j] == 0) {
				continue;
			}

			topologicalSorthelper(graph, j, visited, stack);

		}
		stack.addFirst(src);
	}

	public static void main(String[] args) {

		int[][] graph = new int[7][7];

		graph[0][1] = 10;

		graph[0][4] = 10;

		graph[1][2] = 10;

		graph[2][3] = 10;

		graph[4][3] = 10;

		graph[6][3] = 10;

		graph[5][4] = 10;

		graph[5][6] = 10;

		TopologicalSort(graph);

	}

}
