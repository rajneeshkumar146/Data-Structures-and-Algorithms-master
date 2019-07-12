package Graph;

import java.util.HashSet;
import java.util.LinkedList;

public class DFS_Graph {

	public static void main(String[] args) {
		int[][] arr = { { 0, 1, 0, 0, 0, 1, 0 }, { 1, 1, 1, 0, 0, 1, 1 }, { 0, 1, 0, 0, 0, 1, 0 },
				{ 0, 0, 0, 1, 1, 1, 0 }, { 0, 1, 0, 1, 1, 0, 0 }, { 1, 1, 0, 0, 1, 1, 0 }, { 0, 1, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 0 }, };

		fun(arr);
	}

	private static void fun(int[][] graph) {

		LinkedList<Node> stack = new LinkedList<>();

		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[0].length; i++) {

				if (graph[i][j] == 1) {

					Node node = new Node(i, j);

					stack.addFirst(node);

				}

			}
		}
		helper(graph, stack);
	}

	private static void helper(int[][] graph, LinkedList<Node> stack) {

		HashSet<Node> visited = new HashSet<Node>();

		while (stack.isEmpty()) {

			Node node = stack.removeFirst();
		}

	}

	static class Node {
		int i;
		int j;

		Node(int i, int j) {
			this.i = i;
			this.j = j;
		}

	}
}
