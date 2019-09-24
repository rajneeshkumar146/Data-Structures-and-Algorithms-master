package Graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import Heap.GenericHeap;

public class Graphs {
	protected class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	protected HashMap<String, Vertex> vces = new HashMap<>();

	// Vertex's------------------------------------------------------------------------------

	public int numVertices() {
		return this.vces.size();
	}

	public boolean containsVertex(String vname) {
		return this.vces.containsKey(vname);
	}

	public void addVertex(String vname) {
		if (this.vces.containsKey(vname)) {
			return;
		}

		Vertex nnbrs = new Vertex(); // new_nbrs.
		this.vces.put(vname, nnbrs);
	}

	public void removeVertex(String vname) {
		if (!this.vces.containsKey(vname)) {
			return;
		}
		Vertex contain = this.vces.get(vname);
		ArrayList<String> vnames = new ArrayList<>(contain.nbrs.keySet());
		for (String vn : vnames) {
			this.vces.get(vn).nbrs.remove(vname);
		}

		this.vces.remove(vname);
	}

	// Edge's-----------------------------------------------------------------------------------------------------------------

	public int numEdge() {
		int size = 0;
		ArrayList<String> vnames = new ArrayList<>(this.vces.keySet());
		for (String vname : vnames) {
			Vertex vtx = this.vces.get(vname);
			size += vtx.nbrs.size();
		}

		return size / 2;
	}

	public boolean containsEdge(String v1name, String v2name) {
		Vertex v1vtx = this.vces.get(v1name);
		Vertex v2vtx = this.vces.get(v2name);
		if (v1vtx == null || v2vtx == null) {
			return false;
		}

		return v1vtx.nbrs.containsKey(v2name);
	}

	public void addEdge(String v1name, String v2name, int weight) {
		Vertex v1vtx = this.vces.get(v1name);
		Vertex v2vtx = this.vces.get(v2name);
		if (v1vtx == null || v2vtx == null) {
			return;
		}

		v1vtx.nbrs.put(v2name, weight);
		v2vtx.nbrs.put(v1name, weight);
	}

	public void removeEdge(String v1name, String v2name) {
		if (!containsEdge(v1name, v2name)) {
			return;
		}

		Vertex v1 = this.vces.get(v1name);
		Vertex v2 = this.vces.get(v2name);

		v1.nbrs.remove(v2name);
		v2.nbrs.remove(v1name);

	}

	// HasPath_Display_and_allDisplay----------------------------------------------------------------------------------------------

	public void display() {
		ArrayList<String> vnames = new ArrayList<String>(this.vces.keySet());
		for (String vname : vnames) {

			ArrayList<String> keys = new ArrayList<String>(this.vces.get(vname).nbrs.keySet());
			String str = "";
			for (String key : keys) {
				int cost = this.vces.get(vname).nbrs.get(key);
				str += "(" + key + ":" + cost + ")";
			}

			System.out.println(vname + "=>" + str);

		}
	}

	public boolean hasPath(String v1name, String v2name) {
		return hasPath(v1name, v2name, new HashMap<String, Boolean>());
	}

	private boolean hasPath(String v1name, String v2name, HashMap<String, Boolean> isdone) {
		if (isdone.containsKey(v1name)) {
			return false;
		}
		isdone.put(v1name, true);
		if (this.containsEdge(v1name, v2name)) {
			return true;
		}

		Vertex vtx = this.vces.get(v1name);
		ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());
		for (String key : keys) {
			boolean result = hasPath(key, v2name, isdone);
			if (result == true) {
				return true;
			}
		}

		return false;
	}

	public void hasPathDisplay(String v1name, String v2name) {
		hasPathDisplay(v1name, v2name, new HashMap<String, Boolean>(), v1name);
		System.out.println();
	}

	private void hasPathDisplay(String v1name, String v2name, HashMap<String, Boolean> isdone, String psf) {

		if (isdone.containsKey(v1name)) {
			return;
		}

		isdone.put(v1name, true);

		if (this.containsEdge(v1name, v2name)) {
			System.out.println(psf + " => " + v2name);
			return;
		}
		Vertex vtx = this.vces.get(v1name);
		ArrayList<String> keys = new ArrayList<String>(vtx.nbrs.keySet());
		for (String key : keys) {
			hasPathDisplay(key, v2name, isdone, psf + " => " + key);
		}
	}

	public void hasPathDisplayall(String v1name, String v2name) {
		hasPathDisplayall(v1name, v2name, new HashMap<String, Boolean>(), v1name);
		System.out.println();
	}

	private void hasPathDisplayall(String v1name, String v2name, HashMap<String, Boolean> isdone, String psf) {
		if (isdone.containsKey(v1name)) {
			return;
		}

		isdone.put(v1name, true);

		if (v1name.equals(v2name)) {
			System.out.println(psf);
			isdone.remove(v2name);
			return;
		}
		Vertex vtx = this.vces.get(v1name);
		ArrayList<String> keys = new ArrayList<String>(vtx.nbrs.keySet());
		for (String key : keys) {
			hasPathDisplayall(key, v2name, isdone, psf + " => " + key);
		}

		isdone.remove(v1name);
	}

	public void preOderDisplay(String vname) {
		preOderDisplay(vname, new HashMap<String, Boolean>(), vname);
		System.out.println();
	}

	private void preOderDisplay(String vname, HashMap<String, Boolean> isdone, String psf) {
		if (isdone.containsKey(vname)) {
			return;
		}

		isdone.put(vname, true);
		System.out.println(vname + "via" + psf);
		Vertex vtx = this.vces.get(vname);

		ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());
		for (String key : keys) {
			preOderDisplay(key, isdone, psf + key);

		}
		isdone.remove(vname);

	}

	public void postOderDisplay(String vname) {
		postOderDisplay(vname, new HashMap<String, Boolean>(), vname);
		System.out.println();
	}

	private void postOderDisplay(String vname, HashMap<String, Boolean> isdone, String psf) {
		if (isdone.containsKey(vname)) {
			return;
		}

		isdone.put(vname, true);

		Vertex vtx = this.vces.get(vname);
		ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());
		for (String key : keys) {
			postOderDisplay(key, isdone, psf + key);

		}
		isdone.remove(vname);
		System.out.println(vname + "via" + psf);

	}

	// BFS_DFS_And_BFT_DFT_Irr-----------------------------------------------------------------------------------------------------------------

	private class Pair {
		private String vname;
		private String asf;

		Pair(String vname, String asf) {
			this.vname = vname;
			this.asf = asf;
		}

		Pair() {

		}
	}

	public boolean BFSirr(String v1name, String v2name) {
		HashMap<String, Boolean> isdone = new HashMap<String, Boolean>();
		LinkedList<Pair> que = new LinkedList<Pair>();
		isdone.put(v1name, true);

		// add_root_in_queue.
		Pair rp = new Pair(); // remove_pair.
		rp.vname = v1name;
		rp.asf = v1name;
		que.addLast(rp);

		while (!que.isEmpty()) {
			// dequeue_and_Marked.
			Pair proccess = que.removeFirst();
			isdone.put(proccess.vname, true);

			// Search.
			Vertex vtx = this.vces.get(proccess.vname);
			System.out.println(proccess.vname + " via " + proccess.asf);
			if (this.containsEdge(proccess.vname, v2name)) {
				return true;
			}

			ArrayList<String> keys = new ArrayList<String>(vtx.nbrs.keySet());
			for (String key : keys) {
				if (!isdone.containsKey(key)) {
					Pair np = new Pair(); // remove_pair.
					np.vname = key;
					np.asf = proccess.asf + key;
					que.addLast(np);
				}
			}

		}
		return false;
	}

	public boolean DFSirr(String v1name, String v2name) {
		HashMap<String, Boolean> isdone = new HashMap<String, Boolean>();
		LinkedList<Pair> stack = new LinkedList<Pair>();
		isdone.put(v1name, true);

		// add_root_in_queue.
		Pair rp = new Pair(); // remove_pair.
		rp.vname = v1name;
		rp.asf = v1name;
		stack.addFirst(rp);

		while (!stack.isEmpty()) {
			// dequeue_and_Marked.
			Pair proccess = stack.removeFirst();
			isdone.put(proccess.vname, true);

			// Search.
			Vertex vtx = this.vces.get(proccess.vname);
			System.out.println(proccess.vname + " via " + proccess.asf);
			if (this.containsEdge(proccess.vname, v2name)) {
				return true;
			}

			ArrayList<String> keys = new ArrayList<String>(vtx.nbrs.keySet());
			for (String key : keys) {
				if (!isdone.containsKey(key)) {
					Pair np = new Pair(); // remove_pair.
					np.vname = key;
					np.asf = proccess.asf + key;
					stack.addFirst(np);
				}
			}

		}
		return false;
	}

	public void BFT() {
		HashMap<String, Boolean> isdone = new HashMap<String, Boolean>();
		LinkedList<Pair> que = new LinkedList<Graphs.Pair>();
		ArrayList<String> vnames = new ArrayList<String>(this.vces.keySet());
		for (String vname : vnames) {
			if (isdone.containsKey(vname)) {
				continue;
			}

			Pair rp = new Pair(vname, vname);
			que.addLast(rp);

			while (!que.isEmpty()) {
				Pair proccess = que.removeFirst();
				//
				// if (isdone.containsKey(proccess.vname)) { //
				// 2_tarike_se_print_honse_Bachyega.F
				// continue;
				// }

				isdone.put(proccess.vname, true);

				System.out.println(proccess.vname + " via " + proccess.asf);
				ArrayList<String> keys = new ArrayList<String>(this.vces.get(proccess.vname).nbrs.keySet());
				for (String key : keys) {
					if (!isdone.containsKey(key)) {
						Pair np = new Pair(key, proccess.asf + key);
						que.addLast(np);
					}
				}

			}
		}

	}

	public void DFT() {
		HashMap<String, Boolean> isdone = new HashMap<String, Boolean>();
		LinkedList<Pair> stack = new LinkedList<Graphs.Pair>();
		ArrayList<String> vnames = new ArrayList<String>(this.vces.keySet());
		for (String vname : vnames) {
			if (isdone.containsKey(vname)) {
				continue;
			}

			Pair rp = new Pair(vname, vname);
			stack.addFirst(rp);

			while (!stack.isEmpty()) {
				Pair proccess = stack.removeFirst();

				if (isdone.containsKey(proccess.vname)) { // 2_tarike_se_print_honse_Bachyega.F
					continue;
				}

				isdone.put(proccess.vname, true);

				System.out.println(proccess.vname + " via " + proccess.asf);
				ArrayList<String> keys = new ArrayList<String>(this.vces.get(proccess.vname).nbrs.keySet());
				for (String key : keys) {
					if (!isdone.containsKey(key)) {
						Pair np = new Pair(key, proccess.asf + key);
						stack.addFirst(np);
					}
				}

			}
		}

	}

	// isCyclic_isConected_and_isTre------------------------------------------------------------------------------------------------------------

	public boolean IsCyclic() {
		HashMap<String, Boolean> isdone = new HashMap<String, Boolean>();
		LinkedList<Pair> que = new LinkedList<Graphs.Pair>();
		ArrayList<String> vnames = new ArrayList<String>(this.vces.keySet());
		for (String vname : vnames) {
			if (isdone.containsKey(vname)) {
				return true;
			}

			Pair rp = new Pair(vname, vname); // removed_Pair.
			que.addLast(rp);

			while (!que.isEmpty()) {

				// dequeue_and_Marked.
				Pair process = que.removeFirst();
				if (isdone.containsKey(process.vname)) {
					return true;
				}
				isdone.put(process.vname, true);

				Vertex vtx = this.vces.get(process.vname);
				ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());

				for (String key : keys) {
					// Checked_marked_or_not_and_enqueue.
					if (!isdone.containsKey(key)) {
						Pair nbrp = new Pair(key, process + key); // nbr_pair
						que.addLast(nbrp);
					}
				}
			}
		}
		return false;
	}

	public void IsCyclicAdv() {
		HashMap<String, Boolean> isdone = new HashMap<String, Boolean>();
		LinkedList<Pair> que = new LinkedList<Graphs.Pair>();
		ArrayList<String> vnames = new ArrayList<String>(this.vces.keySet());
		ArrayList<Object> cycliccount = new ArrayList<Object>();
		int count = 0;
		for (String vname : vnames) {
			if (isdone.containsKey(vname)) {
				continue;
			}
			count++;
			Pair rp = new Pair(vname, vname); // removed_Pair.
			que.addLast(rp);

			while (!que.isEmpty()) {

				// dequeue_and_Marked.
				Pair process = que.removeFirst();
				if (isdone.containsKey(process.vname)) {
					cycliccount.add(true);
					continue;
				}
				isdone.put(process.vname, true);

				Vertex vtx = this.vces.get(process.vname);
				ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());

				for (String key : keys) {
					// Checked_marked_or_not_and_enqueue.
					if (!isdone.containsKey(key)) {
						Pair nbrp = new Pair(key, process + key); // nbr_pair
						que.addLast(nbrp);
					}
				}
			}
		}
		cycliccount.add(count);
		System.out.println(cycliccount);
	}

	public boolean IsConnected() {
		HashMap<String, Boolean> isdone = new HashMap<String, Boolean>();
		LinkedList<Pair> que = new LinkedList<Graphs.Pair>();
		ArrayList<String> vnames = new ArrayList<String>(this.vces.keySet());
		int count = 0;
		for (String vname : vnames) {
			if (isdone.containsKey(vname)) {
				continue;
			}
			count++;
			Pair rp = new Pair(vname, vname); // removed_Pair.
			que.addLast(rp);

			while (!que.isEmpty()) {

				// dequeue_and_Marked.
				Pair process = que.removeFirst();
				if (isdone.containsKey(process.vname)) {
					continue;
				}
				isdone.put(process.vname, true);

				Vertex vtx = this.vces.get(process.vname);
				ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());

				for (String key : keys) {
					// Checked_marked_or_not_and_enqueue.
					if (!isdone.containsKey(key)) {
						Pair nbrp = new Pair(key, process + key); // nbr_pair
						que.addLast(nbrp);
					}
				}
			}
		}
		return count == 1;
	}

	public int IsConnectedcount() {
		HashMap<String, Boolean> isdone = new HashMap<String, Boolean>();
		LinkedList<Pair> que = new LinkedList<Graphs.Pair>();
		ArrayList<String> vnames = new ArrayList<String>(this.vces.keySet());
		int count = 0;
		for (String vname : vnames) {
			if (isdone.containsKey(vname)) {
				continue;
			}
			count++;
			Pair rp = new Pair(vname, vname); // removed_Pair.
			que.addLast(rp);

			while (!que.isEmpty()) {

				// dequeue_and_Marked.
				Pair process = que.removeFirst();
				if (isdone.containsKey(process.vname)) {
					continue;
				}
				isdone.put(process.vname, true);

				Vertex vtx = this.vces.get(process.vname);
				ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());

				for (String key : keys) {
					// Checked_marked_or_not_and_enqueue.
					if (!isdone.containsKey(key)) {
						Pair nbrp = new Pair(key, process + key); // nbr_pair
						que.addLast(nbrp);
					}
				}
			}
		}
		return count;
	}

	public boolean IsTree() {
		if (IsCyclic() == false && IsConnected() == true) {
			return true;
		} else {
			return false;
		}
	}

	// bipitrate_and_GetConnectedComponent---------------------------------------------------------------------------------------------------------

	private class PairBi {
		private String vname;
		private String Color;

		public PairBi(String vname, String Color) {
			this.vname = vname;
			this.Color = Color;
		}

		public PairBi() {

		}
	}

	public boolean bipitrate() {
		HashMap<String, String> isdone = new HashMap<String, String>();
		LinkedList<PairBi> que = new LinkedList<Graphs.PairBi>();
		ArrayList<String> vnames = new ArrayList<String>(this.vces.keySet());
		for (String vname : vnames) {
			if (isdone.containsKey(vname)) {
				continue;
			}

			PairBi rp = new PairBi(vname, "R");
			que.addLast(rp);

			while (!que.isEmpty()) {

				PairBi proccess = que.removeFirst();

				if (isdone.containsKey(proccess.vname)) {
					String prevColor = isdone.get(proccess.vname);
					String currColor = proccess.Color;
					if (!prevColor.equals(currColor)) {
						return false;
					}
					continue;
				}

				isdone.put(proccess.vname, proccess.Color);
				System.out.println(proccess.vname + " against " + proccess.Color);

				ArrayList<String> keys = new ArrayList<String>(this.vces.get(proccess.vname).nbrs.keySet());
				for (String key : keys) {
					if (!isdone.containsKey(key)) {
						if (proccess.Color.equals("R")) {
							PairBi np = new PairBi(key, "G");
							que.addLast(np);
						} else {
							PairBi np = new PairBi(key, "R");
							que.addLast(np);
						}
					}
				}

			}

		}

		return true;

	}

	private class PairGCC {
		private String vname;

		private PairGCC(String vname) {
			this.vname = vname;
		}
	}

	public void GCC() { // Get_Connected_components.
		HashMap<String, Boolean> isdone = new HashMap<String, Boolean>();
		LinkedList<PairGCC> que = new LinkedList<Graphs.PairGCC>();
		ArrayList<String> vnames = new ArrayList<String>(this.vces.keySet());
		ArrayList<String> ans = new ArrayList<String>();
		for (String vname : vnames) {
			if (isdone.containsKey(vname)) {
				continue;
			}

			String str = new String();

			PairGCC rp = new PairGCC(vname);
			que.addLast(rp);

			while (!que.isEmpty()) {

				PairGCC proccess = que.removeFirst();

				if (isdone.containsKey(proccess.vname)) {
					continue;
				}

				str += proccess.vname;
				isdone.put(proccess.vname, true);

				ArrayList<String> keys = new ArrayList<String>(this.vces.get(proccess.vname).nbrs.keySet());
				for (String key : keys) {
					if (!isdone.containsKey(key)) {
						PairGCC np = new PairGCC(key);
						que.addLast(np);
					}

				}
			}
			ans.add(str);
		}
		System.out.println(ans);
	}

	// Dijikstra----------------------------------------------------------------------------------------------------------------------------------

	private class DijikstraPair implements Comparable<DijikstraPair> {
		private String vname;
		private String asf = "";
		private int csf = Integer.MAX_VALUE;

		@Override
		public int compareTo(DijikstraPair o) {

			return this.csf - o.csf;
		}

		@Override
		public String toString() {
			return "[" + this.asf + " @ " + this.csf + "]";
		}

	}

	public HashMap<String, DijikstraPair> Dijikstra(String srcvname) { // Source_Vertex_Name
		HashMap<String, DijikstraPair> map = new HashMap<String, DijikstraPair>();
		PriorityQueue<DijikstraPair> queue = new PriorityQueue<DijikstraPair>();
		ArrayList<String> vnames = new ArrayList<String>(this.vces.keySet());
		for (String vname : vnames) {
			DijikstraPair pair = new DijikstraPair();
			pair.vname = vname;
			if (vname.equals(srcvname)) {
				pair.csf = 0;
				pair.asf = vname;
			}

			map.put(vname, pair);
			queue.add(pair);
		}

		while (!queue.isEmpty()) {
			DijikstraPair proccess = queue.remove();
			ArrayList<String> keys = new ArrayList<String>(this.vces.get(proccess.vname).nbrs.keySet());
			for (String key : keys) {
				DijikstraPair evalutionPair = map.get(key);
				int oldcost = evalutionPair.csf;
				int newcost = proccess.csf + this.vces.get(key).nbrs.get(proccess.vname);
				if (newcost < oldcost) {
					evalutionPair.csf = newcost;
					evalutionPair.vname = key;
					evalutionPair.asf = proccess.asf + key;
					queue.remove(evalutionPair);
					queue.add(evalutionPair);
				}
			}
		}

		return map;
	}

	// Prim's---------------------------------------------------------------------------------------------------------------------------------------

	private static class PrimsPair {

		private String vname;
		private int csf = Integer.MAX_VALUE;
		private String avname = null; // accuaringVertexName.

		public PrimsPair(String vname, String avname, int csf) {
			this.vname = vname;
			this.avname = avname;
			this.csf = csf;
		}

		public PrimsPair() {

		}

		private static final PrimsPaircompatator ctor = new PrimsPaircompatator();

		private static class PrimsPaircompatator implements Comparator<PrimsPair> {
			@Override
			public int compare(PrimsPair o1, PrimsPair o2) {
				// TODO Auto-generated method stub
				return o2.csf - o1.csf;
			}
		}
	}

	public Graphs PrimsMST(String srcvname) throws Exception {
		Graphs gp = new Graphs();
		HashMap<String, PrimsPair> map = new HashMap<String, Graphs.PrimsPair>();
		GenericHeap<PrimsPair> queue = new GenericHeap<Graphs.PrimsPair>(PrimsPair.ctor);
		ArrayList<String> vnames = new ArrayList<String>(this.vces.keySet());
		for (String vname : vnames) {
			PrimsPair pair = new PrimsPair();
			pair.vname = vname;

			map.put(vname, pair);
			queue.add(pair);
		}

		while (!queue.isEmpty()) {
			PrimsPair rp = queue.remove();
			gp.addVertex(rp.vname);
			if (rp.avname != null) {
				gp.addEdge(rp.vname, rp.avname, rp.csf);
			}

			ArrayList<String> keys = new ArrayList<String>(this.vces.get(rp.vname).nbrs.keySet());
			for (String key : keys) {
				if (gp.containsVertex(key)) {
					continue;
				}
				PrimsPair np = map.get(key);
				int cost = this.vces.get(key).nbrs.get(rp.vname);
				if (cost < np.csf) {
					np.avname = rp.vname;
					np.csf = cost;
					queue.update(np);

				}

			}

		}

		return gp;
	}

	// Kruskal's------------------------------------------------------------------------------------------------------------------------------------

	private class Cluster {
		private String vname;
		private Cluster parent;
		private int size;

		public Cluster(String vname) {
			this.vname = vname;
			this.parent = this;
			this.size = 1;
		}

		public Cluster FindLeader() {
			if (this.parent != this) {
				return this.parent.FindLeader();
			} else {
				return this;
			}
		}

		public void Merge(Cluster other) {
			if (this.size < other.size) {
				this.parent = other;
				other.size += this.size;
			} else {
				other.parent = this;
				this.size += other.size;
			}
		}

	}

	private static class KruskalPair {
		private String v1name;
		private String v2name;
		private int weight;

		private static final KruskalPairComparator ctor = new KruskalPairComparator();

		private static class KruskalPairComparator implements Comparator<KruskalPair> {

			@Override
			public int compare(KruskalPair o1, KruskalPair o2) {

				return o2.weight - o1.weight;
			}

		}

	}

	public Graphs Kruskal() throws Exception {
		Graphs gp = new Graphs();
		HashMap<String, Cluster> partition = new HashMap<String, Graphs.Cluster>();
		GenericHeap<KruskalPair> heap = new GenericHeap<Graphs.KruskalPair>(KruskalPair.ctor);
		ArrayList<String> vnames = new ArrayList<String>(this.vces.keySet());
		for (String vname : vnames) {
			Cluster cluster = new Cluster(vname);
			partition.put(vname, cluster);

			ArrayList<String> keys = new ArrayList<String>(this.vces.get(vname).nbrs.keySet());
			for (String key : keys) {
				if (partition.containsKey(key)) {
					continue;
				}

				KruskalPair kp = new KruskalPair();
				kp.v1name = vname;
				kp.v2name = key;
				kp.weight = this.vces.get(vname).nbrs.get(key);
				heap.add(kp);
			}
		}

		while (gp.numEdge() != this.numVertices() - 1) {

			KruskalPair rp = heap.remove();
			Cluster c1 = partition.get(rp.v1name);
			Cluster c2 = partition.get(rp.v2name);

			Cluster c1Leader = c1.FindLeader();
			Cluster c2Leader = c2.FindLeader();
			if (c1Leader != c2Leader) { // if_Both_are_not_from_same_set_then_there_is_no_cycle.
				gp.addVertex(rp.v1name);
				gp.addVertex(rp.v2name);
				gp.addEdge(rp.v1name, rp.v2name, rp.weight);

				c1.Merge(c2);
			}

		}

		return gp;
	}

}
