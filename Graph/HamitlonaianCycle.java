package Graph;

import java.util.ArrayList;
import java.util.HashSet;

import Graph.Graph_AdjacencyLIst.Edge;

public class HamitlonaianCycle {

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

		HamitlonaianCycle(Graph, 1);

	}

}
