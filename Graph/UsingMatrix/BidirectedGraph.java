package Graphs.UsingMatrix;

import java.util.HashSet;
import java.util.Scanner;

public class BidirectedGraph {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int[][] graph = new int[7][7];

		addEdge(graph, 0, 1, 10);
		addEdge(graph, 1, 2, 10);
		addEdge(graph, 2, 3, 10);
		addEdge(graph, 0, 3, 40);
		addEdge(graph, 3, 4, 2);
		addEdge(graph, 4, 5, 3);
		addEdge(graph, 4, 6, 8);
		addEdge(graph, 5, 6, 3);

		addEdge(graph, 2, 5, 100);

		// printAllPaths(0, 6, graph, new boolean[7], "0");

		HamiltonianCycle(graph, 2);

	}

	private static void addEdge(int[][] graph, int i, int j, int wt) {
		graph[i][j] = wt;
		graph[j][i] = wt;
	}

	private static void printAllPaths(int src, int desti, int[][] graph, boolean[] visted, String psf) {
		if (src == desti) {
			System.out.println(psf);
			return;
		}

		visted[src] = true;
		for (int i = 0; i < graph[0].length; i++) {
			if (graph[src][i] == 0 || visted[i]) {
				continue;
			}

			printAllPaths(i, desti, graph, visted, psf + i);
		}
		visted[src] = false;

	}

	// HamintonianCycle_And_Path.===================================================================================

	public static void HamiltonianCycle(int[][] graph, int src) {
		boolean res = HamiltonianCycle(graph, new HashSet<>(), src, src, src + "");
		if (!res) {
			System.out.println("No Hamintonian Path");
		}
	}

	private static boolean HamiltonianCycle(int[][] graph, HashSet<Integer> visited, int src, int osrc, String psf) {
		if (visited.size() == graph.length - 1) {
			if (graph[src][osrc] != 0) {
				System.out.println("Hamiltonian Cycle: " + psf);
			} else {
				System.out.println("Hamiltonian Path: " + psf);
			}

			return true;
		}

		visited.add(src);
		boolean res = false;
		for (int j = 0; j < graph[0].length; j++) {
			if (graph[src][j] == 0 || visited.contains(j)) {
				continue;
			}
			res = HamiltonianCycle(graph, visited, j, osrc, psf + j);
		}

		visited.remove(src);
		return res;
	}

}
