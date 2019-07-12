package Graph;

import java.util.ArrayList;

public class BelmanFord {

	public class Pair {

		int dist;
		String path;

		Pair(int dist, String path) {
			this.dist = dist;
			this.path = path;
		}

	}

	public class Edge {

		int u;
		int v;
		int wt;

		Edge(int u, int v, int wt) {
			this.u = u;
			this.v = v;
			this.wt = wt;
		}

	}

	public static Pair[] BelmanFord(Integer[][] graph) {

		Pair[] spair = new Pair[graph.length];

		ArrayList<Edge> edges = new ArrayList<>();

		for (Edge e : edges) {
			if ((spair[e.u].path != null) && (spair[e.u].dist + graph[e.u][e.v] < spair[e.v].dist)) {

			}
		}

		return null;

	}

	public static void main(String[] args) {

		Integer[][] graph = new Integer[4][4];

		graph[0][1] = 10;
		graph[0][2] = 20;
		graph[1][3] = 8;
		graph[2][3] =-3;

		Pair[] ans = BelmanFord(graph);

	}

}
