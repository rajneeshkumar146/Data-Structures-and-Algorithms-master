package Graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class BellmanFord {

	public static void main(String[] args) {
		ArrayList<String> Vertexs = new ArrayList<String>();
		ArrayList<Edge> GraphEdge = new ArrayList<Edge>();

		Vertexs.add("A");
		Vertexs.add("B");
		Vertexs.add("C");
		Vertexs.add("D");

		GraphEdge.add(new Edge("A", "D", 8));
		GraphEdge.add(new Edge("A", "B", 3));
		GraphEdge.add(new Edge("C", "A", -5));
		GraphEdge.add(new Edge("C", "D", 2));
		GraphEdge.add(new Edge("B", "C", 1));

		HashMap<String, BMpair> result = new HashMap<String, BMpair>();
		String srcvname = "A";
		for (String vname : Vertexs) {
			BMpair pair = new BMpair();
			if (vname.equals(srcvname)) {
				pair.psf = vname;
				pair.csf = 0;
			}

			pair.psf = null;
			pair.csf = Integer.MAX_VALUE;

			result.put(vname, pair);
		}

		for (int i = 1; i <= Vertexs.size() - 1; i++) {
			for (Edge edge : GraphEdge) {
				BMpair svname = result.get(edge.v1name);
				BMpair dvname = result.get(edge.v2name);
				int weight = edge.weight;
				if (svname.psf == null) {
					continue;
				} else if (svname.csf + weight < dvname.csf) {
					dvname.csf = svname.csf + weight;
					dvname.psf = svname.psf + dvname.psf;
				}
			}
		}

		for (Edge edge : GraphEdge) {
			BMpair svname = result.get(edge.v1name);
			BMpair dvname = result.get(edge.v2name);
			int weight = edge.weight;
			if (svname.psf == null) {
				continue;
			} else if (svname.csf + weight < dvname.csf) {
				System.out.println("Cycle");
				return;
			}
		}
		
		System.out.println(result);

	}

	private static class Edge {
		private String v1name;
		private String v2name;
		private int weight;

		public Edge(String v1name, String v2name, int weight) {
			this.v1name = v1name;
			this.v2name = v2name;
			this.weight = weight;
		}
	}

	private static class BMpair {
		private String psf;
		private int csf;

		@Override
		public String toString() {
			return "[" + this.psf + " via " + this.csf + "]";
		}

	}

}
