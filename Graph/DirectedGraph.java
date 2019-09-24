package Graphs;

import java.util.ArrayList;

import Graphs.Graphs.Vertex;

public class DirectedGraph extends Graphs {
	@Override
	public int numEdge() {
		int size = 0;
		ArrayList<String> vnames = new ArrayList<>(this.vces.keySet());
		for (String vname : vnames) {
			Vertex vtx = this.vces.get(vname);
			size += vtx.nbrs.size();
		}

		return size;
	}

	@Override
	public void removeVertex(String vname) {

		ArrayList<String> keys = new ArrayList<String>(this.vces.keySet());
		for (String key : keys) {
			this.vces.get(key).nbrs.remove(vname);
		}
		this.vces.remove(vname);

	}

	@Override
	public void addEdge(String Hvname, String Tvname, int weight) {
		Vertex Hvtx = this.vces.get(Hvname);
		Vertex Tvtx = this.vces.get(Tvname);
		if (Hvtx == null || Tvtx == null) {
			return;
		}

		Hvtx.nbrs.put(Tvname, weight);
	}
	
	@Override
	public void removeEdge(String v1name, String v2name) {
		if (!containsEdge(v1name, v2name)) {
			return;
		}

		Vertex v1 = this.vces.get(v1name);
		Vertex v2 = this.vces.get(v2name);

		v1.nbrs.remove(v2name);
	}

}
