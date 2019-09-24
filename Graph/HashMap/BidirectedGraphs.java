package Graphs.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class BidirectedGraphs {

	private static HashMap<String, HashMap<String, Integer>> map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		addVertex("A");
		addVertex("B");
		addVertex("C");
		addVertex("D");
		addVertex("E");
		addVertex("F");
		addVertex("G");

		addEdge("A", "B", 10);
		addEdge("A", "D", 40);
		addEdge("B", "C", 10);
		addEdge("C", "D", 10);
		addEdge("D", "E", 2);
		// addEdge("C", "F", 2);
		addEdge("E", "F", 3);
		addEdge("E", "G", 8);
		addEdge("F", "G", 3);

		// display();

		// HashPath("A", "G");
		// HashPathDisplay("A", "G");
		// HashPathDisplayALL("A", "G");
		// preOder("A");
		// postOder("A");
		// GetShortestPath("A", "G");

		// System.out.println(DFS("A", "G"));
		// DFT();
		// System.out.println(BFS("A", "G"));
		// BFT();

		// System.out.println(IsCyclic("A"));
		// IsCyclicInForest();
		// System.out.println(IsConected());
		// System.out.println(IsTree("A"));

		// GetConnected();

		// System.out.println(Bipitrate());

		// hamintonainCycleDetection("A");

		// Kruskal();
		// Dijikstra("A");

		Prims();

	}

	// Vertex.==========================================================================================

	public static void addVertex(String vtx) {
		if (map.containsKey(vtx)) { // if_is_already_present_then_just_return..
			return;
		}

		map.put(vtx, new HashMap<>());
	}

	public static void removeVertex(String vtx) {
		if (!map.containsKey(vtx)) {
			return;
		}

		ArrayList<String> keys = new ArrayList<>(map.get(vtx).keySet());
		for (String key : keys) {
			map.get(key).remove(vtx);
		}

		map.remove(vtx);

	}

	// Edge.==========================================================================================

	public static void addEdge(String vtx1, String vtx2, Integer value) {
		if (!map.containsKey(vtx1) || !map.containsKey(vtx2)) { // if_vertex_is_not_present_then_there_is_no_possiblity_to_add_edge.
			return;
		} else {
			map.get(vtx1).put(vtx2, value);
			map.get(vtx2).put(vtx1, value);
		}
	}

	public static boolean ContainsEdge(String vtx1, String vtx2) {
		if (!map.containsKey(vtx1) || !map.containsKey(vtx2) || !map.get(vtx1).containsKey(vtx2)) {
			return false;
		}

		return true;
	}

	public static void removeEdges(String vtx1, String vtx2) {
		if (!ContainsEdge(vtx1, vtx2)) {
			return;
		}
		map.get(vtx1).remove(vtx2);
		map.get(vtx2).remove(vtx1);
	}

	public static int NumberOfEdges() {
		int count = 0;
		ArrayList<String> keys = new ArrayList<>(map.keySet());
		for (String key : keys) {
			count += map.get(key).size();
		}

		return count >> 1;

	}

	// display.=============================================================================================

	public static void display() {
		StringBuilder sb = new StringBuilder();
		ArrayList<String> keys = new ArrayList<>(map.keySet());

		for (String key : keys) {
			sb.append(key + " => ");
			sb.append(map.get(key) + "\n");
		}

		System.out.println(sb.toString());

	}

	public static void HashPath(String vtx1, String vtx2) {
		boolean res = HashPath(vtx1, vtx2, new HashSet<>());
		System.out.println(res);
	}

	private static boolean HashPath(String vtx1, String vtx2, HashSet<String> isdone) {

		isdone.add(vtx1);
		if ((ContainsEdge(vtx1, vtx2))) {
			return true;
		}

		ArrayList<String> keys = new ArrayList<>(map.get(vtx1).keySet());
		boolean res = false;
		for (String key : keys) {
			if (isdone.contains(key)) {
				continue;
			}
			res = res || HashPath(key, vtx2, isdone);
		}

		return res;

	}

	public static void HashPathDisplay(String vtx1, String vtx2) {

		HashPathDisplay(vtx1, vtx2, vtx1, new HashSet<>());

	}

	private static void HashPathDisplay(String vtx1, String vtx2, String ans, HashSet<String> isdone) {
		isdone.add(vtx1);
		if (ContainsEdge(vtx1, vtx2)) {
			System.out.println(ans + " => G");
			return;
		}

		ArrayList<String> keys = new ArrayList<>(map.get(vtx1).keySet());
		for (String key : keys) {
			if (isdone.contains(key)) {
				continue;
			}

			HashPathDisplay(key, vtx2, ans + " => " + key, isdone);
		}

	}

	public static void HashPathDisplayALL(String vtx1, String vtx2) {

		HashPathDisplayALL(vtx1, vtx2, vtx1, new HashSet<>());

	}

	private static void HashPathDisplayALL(String vtx1, String vtx2, String ans, HashSet<String> isdone) {
		if (vtx1.equals(vtx2)) {
			System.out.println(ans);
			return;
		}
		isdone.add(vtx1);
		ArrayList<String> keys = new ArrayList<>(map.get(vtx1).keySet());
		for (String key : keys) {
			if (isdone.contains(key)) {
				continue;
			}

			HashPathDisplayALL(key, vtx2, ans + " => " + key, isdone);

		}

		isdone.remove(vtx1);

	}

	public static void preOder(String str) {
		preOder(str, new HashSet<>(), str);
	}

	private static void preOder(String str, HashSet<String> isdone, String ans) {

		if (isdone.contains(str)) {
			return;
		}

		isdone.add(str);
		System.out.println(str + " => " + ans);

		ArrayList<String> keys = new ArrayList<>(map.get(str).keySet());
		for (String key : keys) {
			if (isdone.contains(key)) {
				continue;
			}

			preOder(key, isdone, ans + key);
		}

		isdone.remove(str);
	}

	public static void postOder(String str) {
		postOder(str, new HashSet<>(), str);
	}

	private static void postOder(String str, HashSet<String> isdone, String ans) {

		if (isdone.contains(str)) {
			return;
		}

		isdone.add(str);
		ArrayList<String> keys = new ArrayList<>(map.get(str).keySet());
		for (String key : keys) {
			if (isdone.contains(key)) {
				continue;
			}

			postOder(key, isdone, ans + key);

		}
		isdone.remove(str);
		System.out.println(str + " => " + ans);

	}

	public static void GetShortestPath(String vtx1, String vtx2) {
		Pair1 pair = GetShortestPath(vtx1, vtx2, new HashSet<>());
		System.out.println(pair.psf + "@" + pair.cost);

	}

	private static class Pair1 {
		private int cost = Integer.MAX_VALUE;
		private String psf = "";

	}

	private static Pair1 GetShortestPath(String vtx1, String vtx2, HashSet<String> isdone) {
		if (vtx1.equals(vtx2)) {
			Pair1 bp = new Pair1();
			bp.cost = 0;
			bp.psf = vtx1;
			return bp;
		}

		Pair1 mp = new Pair1();

		isdone.add(vtx1);

		ArrayList<String> keys = new ArrayList<>(map.get(vtx1).keySet());
		for (String key : keys) {
			if (isdone.contains(key)) {
				continue;
			}

			Pair1 npair = GetShortestPath(key, vtx2, isdone);

			int cost = map.get(vtx1).get(key);
			if (npair.psf.length() > 0 && cost + npair.cost < mp.cost) {
				mp.cost = cost + npair.cost;
				mp.psf = vtx1 + npair.psf;
			}

		}

		isdone.remove(vtx1);
		return mp;
	}

	// BSF_DFS_BFT_DFT.===================================================================================

	private static class Pair {
		private String asf;
		private String vtx;

		public Pair(String vtx, String asf) {
			this.asf = asf;
			this.vtx = vtx;
		}
	}

	public static boolean DFS(String vtx1, String vtx2) {
		HashSet<String> isdone = new HashSet<>();
		LinkedList<Pair> stack = new LinkedList<>();
		Pair pair = new Pair(vtx1, vtx1);
		stack.addFirst(pair);

		while (!stack.isEmpty()) {
			Pair process = stack.removeFirst();
			isdone.add(process.vtx);

			System.out.println(process.vtx + " via " + process.asf);
			if (process.vtx.equals(vtx2)) {
				return true;
			}

			ArrayList<String> keys = new ArrayList<>(map.get(process.vtx).keySet());
			for (String key : keys) {
				if (isdone.contains(key)) {
					continue;
				}

				Pair npair = new Pair(key, process.asf + key);
				stack.addFirst(npair);
			}

		}
		return false;

	}

	public static void DFT() {
		HashSet<String> isdone = new HashSet<>();
		for (String keys : map.keySet()) {
			if (isdone.contains(keys)) {
				continue;
			}
			// DFTComponent(keys, isdone);
			System.out.println(DFTCComponentRecur(keys, isdone));
		}
	}

	private static void DFTComponent(String vtx1, HashSet<String> isdone) {
		LinkedList<Pair> stack = new LinkedList<>();
		Pair pair = new Pair(vtx1, vtx1);
		stack.addFirst(pair);

		while (!stack.isEmpty()) {
			Pair process = stack.removeFirst();

			if (isdone.contains(process.vtx)) { // CycleValeKoPrintNahiKrega.
				continue;
			}

			isdone.add(process.vtx);

			System.out.println(process.vtx + " via " + process.asf);

			ArrayList<String> keys = new ArrayList<>(map.get(process.vtx).keySet());
			for (String key : keys) {
				if (isdone.contains(key)) {
					continue;
				}

				Pair npair = new Pair(key, process.asf + key);
				stack.addFirst(npair);
			}
		}
	}

	private static String DFTCComponentRecur(String src, HashSet<String> isdone) {

		isdone.add(src);

		String ans = src;
		for (String key : map.get(src).keySet()) {
			if (isdone.contains(key)) {
				continue;
			}

			ans += DFTCComponentRecur(key, isdone);
		}

		return ans;

	}

	public static boolean BFS(String vtx1, String vtx2) {
		HashSet<String> isdone = new HashSet<>();
		LinkedList<Pair> queue = new LinkedList<>();
		Pair pair = new Pair(vtx1, vtx1);
		queue.addLast(pair);

		while (!queue.isEmpty()) {
			Pair process = queue.removeFirst();

			if (isdone.contains(process.vtx)) { // Best_Spot_cycle_detection.
				continue;
			}

			isdone.add(process.vtx);

			System.out.println(process.vtx + " via " + process.asf);
			if (process.vtx.equals(vtx2)) {
				return true;
			}

			ArrayList<String> keys = new ArrayList<>(map.get(process.vtx).keySet());
			for (String key : keys) {
				if (isdone.contains(key)) {
					continue;
				}

				Pair npair = new Pair(key, process.asf + key);
				queue.addLast(npair);
			}
		}
		return false;
	}

	public static void BFT() {
		HashSet<String> isdone = new HashSet<>();
		for (String keys : map.keySet()) {
			if (isdone.contains(keys)) {
				continue;
			}
			BFTComponent(keys, isdone);
		}
	}

	private static void BFTComponent(String vtx1, HashSet<String> isdone) {
		LinkedList<Pair> queue = new LinkedList<>();
		Pair pair = new Pair(vtx1, vtx1);
		queue.addLast(pair);

		while (!queue.isEmpty()) {
			Pair process = queue.removeFirst();

			if (isdone.contains(process.vtx)) { // CycleValeKoPrintNahiKrega.
				continue;
			}

			isdone.add(process.vtx);

			System.out.println(process.vtx + " via " + process.asf);

			ArrayList<String> keys = new ArrayList<>(map.get(process.vtx).keySet());
			for (String key : keys) {
				if (isdone.contains(key)) {
					continue;
				}

				Pair npair = new Pair(key, process.asf + key);
				queue.addLast(npair);
			}
		}
	}

	// isCyclic_isConected_and_isTree=====================================================================

	private static int IsCyclic(String src) {
		HashSet<String> isdone = new HashSet<>();
		LinkedList<Pair> queue = new LinkedList<>();
		Pair pair = new Pair(src, src);

		queue.addLast(pair);
		int count = 0;
		while (!queue.isEmpty()) {
			Pair process = queue.removeFirst();

			if (isdone.contains(process.vtx)) {
				count++;
			}

			isdone.add(process.vtx);

			// System.out.println(process.asf);
			ArrayList<String> keys = new ArrayList<>(map.get(process.vtx).keySet());
			for (String key : keys) {
				if (isdone.contains(key)) {
					continue;
				}

				Pair npair = new Pair(key, process.asf + key);
				queue.addLast(npair);
			}

		}
		// System.out.println(count > 0 ? "YES -> " + count : "NO");
		return count;

	}

	private static void IsCyclicInForest() {

		HashSet<String> isdone = new HashSet<>();
		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<String> vces = new ArrayList<>(map.keySet());
		int components = 0;
		int Cyclecount = 0;

		for (String vce : vces) {
			if (isdone.contains(vce)) {
				continue;
			}
			components++;

			Pair pair = new Pair(vce, vce);

			queue.addLast(pair);

			while (!queue.isEmpty()) {
				Pair process = queue.removeFirst();

				if (isdone.contains(process.vtx)) {
					Cyclecount++;
				}

				isdone.add(process.vtx);

				// System.out.println(process.asf);
				ArrayList<String> keys = new ArrayList<>(map.get(process.vtx).keySet());
				for (String key : keys) {
					if (isdone.contains(key)) {
						continue;
					}

					Pair npair = new Pair(key, process.asf + key);
					queue.addLast(npair);
				}

			}
		}

		System.out.println("Components: " + components + "\nCyclicCount: " + Cyclecount);

	}

	private static boolean IsConected() {
		HashSet<String> isdone = new HashSet<>();
		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<String> vces = new ArrayList<>(map.keySet());
		int components = 0;

		for (String vce : vces) {
			if (isdone.contains(vce)) {
				continue;
			}
			components++;

			Pair pair = new Pair(vce, vce);

			queue.addLast(pair);

			while (!queue.isEmpty()) {
				Pair process = queue.removeFirst();

				if (isdone.contains(process.vtx)) {
					continue;
				}

				isdone.add(process.vtx);

				// System.out.println(process.asf);
				ArrayList<String> keys = new ArrayList<>(map.get(process.vtx).keySet());
				for (String key : keys) {
					if (isdone.contains(key)) {
						continue;
					}

					Pair npair = new Pair(key, process.asf + key);
					queue.addLast(npair);
				}

			}

		}
		return components == 1;
	}

	private static boolean IsTree(String src) {

		return ((IsConected() && IsCyclic(src) == 0) ? true : false);
	}

	// bipitrate_and_GetConnectedComponent.===============================================================

	private static class BipitratePair {
		private String vtx;
		private String color;

		public BipitratePair(String vtx, String color) {
			this.vtx = vtx;
			this.color = color;
		}
	}

	public static boolean Bipitrate() {

		HashMap<String, BipitratePair> isdone = new HashMap<>();
		LinkedList<BipitratePair> queue = new LinkedList<>();

		ArrayList<String> vces = new ArrayList<>(map.keySet());
		for (String vce : vces) {
			if (isdone.containsKey(vce)) {
				continue;
			}

			BipitratePair pair = new BipitratePair(vce, "R");
			queue.addLast(pair);
			while (!queue.isEmpty()) {
				BipitratePair process = queue.removeFirst();

				if (isdone.containsKey(process.vtx)) {
					if (!process.color.equals(isdone.get(process.vtx).color)) {
						return false;
					}
					continue;
				}

				isdone.put(process.vtx, process);

				ArrayList<String> keys = new ArrayList<>(map.get(process.vtx).keySet());
				for (String key : keys) {
					if (isdone.containsKey(key)) {
						continue;
					}

					BipitratePair npair = new BipitratePair(key, process.color.equals("R") ? "G" : "R");
					queue.addLast(npair);

				}
			}

		}

		return true;
	}

	public static void GetConnected() {
		ArrayList<String> ans = new ArrayList<>();
		HashSet<String> isdone = new HashSet<>();
		for (String key : map.keySet()) {
			if (isdone.contains(key)) {
				continue;
			}

			ans.add(GetConectedComponents(key, isdone));
			// ans.add(GetConectedComponentsRecu(key, isdone));
		}

		System.out.println(ans);
	}

	private static String GetConectedComponents(String vce, HashSet<String> isdone) {

		LinkedList<Pair> queue = new LinkedList<>();
		Pair pair = new Pair(vce, vce);
		queue.addLast(pair);

		String path = "";
		while (!queue.isEmpty()) {
			Pair process = queue.removeFirst();

			if (isdone.contains(process.vtx)) {
				continue;
			}

			isdone.add(process.vtx);

			path += process.vtx;
			// System.out.println(process.asf);
			ArrayList<String> keys = new ArrayList<>(map.get(process.vtx).keySet());
			for (String key : keys) {
				if (isdone.contains(key)) {
					continue;
				}

				Pair npair = new Pair(key, process.asf + key);
				queue.addLast(npair);
			}

		}
		return path;
	}

	private static String GetConectedComponentsRecu(String vce, HashSet<String> isdone) {
		isdone.add(vce);
		String ans = vce;
		for (String key : map.get(vce).keySet()) {
			if (isdone.contains(key)) {
				continue;
			}
			ans += GetConectedComponentsRecu(key, isdone);
		}

		return ans;

	}

	// HamintonianCycle_And_Path.===================================================================================

	public static void hamintonainCycleDetection(String src) {
		boolean res = hamintonainCycleDetection(src, src, src, new HashSet<String>());
		if (!res) {
			System.out.println("No hamintonain Cycle.");
		}
	}

	private static boolean hamintonainCycleDetection(String src, String osrc, String psf, HashSet<String> isdone) {
		if (isdone.size() == map.size() - 1) {
			if (map.get(src).containsKey(osrc)) {
				System.out.println("Hamiltonian Cycle: " + psf);
			} else {
				System.out.println("Hamiltonian Path: " + psf);
			}

			return true;
		}

		isdone.add(src);
		boolean res = false;
		for (String key : map.get(src).keySet()) {
			if (isdone.contains(key)) {
				continue;
			}
			res = hamintonainCycleDetection(key, osrc, psf + key, isdone);
		}

		isdone.remove(src);
		return res;
	}

	// Kruskal.=======================================================================================================

	private static class Cluster {
		private String parent;
		private int size;

		public Cluster(String parent, int size) {
			this.parent = parent;
			this.size = size;
		}
	}

	private static String FindLeader(HashMap<String, Cluster> DisjointSet, String vtx) {
		Cluster c = DisjointSet.get(vtx);

		if (c.parent.equals(vtx)) {
			return vtx;
		} else {
			c.parent = FindLeader(DisjointSet, c.parent);
			return c.parent;
		}
	}

	private static void Union(Cluster c1, Cluster c2) {
		if (c1.size > c2.size) {
			c2.parent = c1.parent;
			c1.size += c2.size;
			c2.size = -1;
		} else {
			c1.parent = c2.parent;
			c2.size += c1.size;
			c1.size = -1;
		}

	}

	private static class KruskalPair implements Comparable<KruskalPair> {
		private String vtx1;
		private String vtx2;
		private int Weight;

		public KruskalPair(String vtx1, String vtx2, int Weight) {
			this.vtx1 = vtx1;
			this.vtx2 = vtx2;
			this.Weight = Weight;
		}

		@Override
		public String toString() {
			return "(" + this.vtx1 + " -> " + this.vtx2 + ") " + this.Weight;
		}

		@Override
		public int compareTo(KruskalPair o) {
			return this.Weight - o.Weight;
		}

	}

	public static void Kruskal() {
		HashSet<KruskalPair> graph = KruskalHelper();

		for (KruskalPair pair : graph) {
			System.out.println(pair);
		}
	}

	private static HashSet<KruskalPair> KruskalHelper() {
		HashSet<KruskalPair> graph = new HashSet<>();

		HashMap<String, Cluster> DisjointSet = new HashMap<>();
		PriorityQueue<KruskalPair> heap = new PriorityQueue<>();

		for (String key : map.keySet()) {
			DisjointSet.put(key, new Cluster(key, 1));

			for (String child : map.get(key).keySet()) {
				if (DisjointSet.containsKey(child)) {
					continue;
				}

				heap.add(new KruskalPair(key, child, map.get(key).get(child)));
			}
		}

		while (heap.size() > 0) {

			KruskalPair process = heap.remove();

			String leader1 = FindLeader(DisjointSet, process.vtx1);
			String leader2 = FindLeader(DisjointSet, process.vtx2);

			if (!leader1.equals(leader2)) {
				Cluster c1 = DisjointSet.get(leader1);
				Cluster c2 = DisjointSet.get(leader2);

				Union(c1, c2);
				graph.add(process);
			}

		}

		return graph;
	}

	// Dijikstra.====================================================================================================

	private static class DijikstraPair implements Comparable<DijikstraPair> {
		private String vtx;
		private String psf;
		private int csf;

		public DijikstraPair(String vtx, String psf, int csf) {
			this.vtx = vtx;
			this.psf = psf;
			this.csf = csf;
		}

		@Override
		public int compareTo(DijikstraPair o) {
			return this.csf - o.csf;
		}

		@Override
		public String toString() {
			return this.vtx + " -> " + this.psf + " @ " + this.csf;
		}
	}

	private static void Dijikstra(String src) {

		PriorityQueue<DijikstraPair> heap = new PriorityQueue<>();
		HashMap<String, DijikstraPair> res = new HashMap<>();
		HashSet<String> isdone = new HashSet<>();

		for (String vce : map.keySet()) {
			if (!vce.equals(src)) {
				DijikstraPair pair = new DijikstraPair(vce, "", Integer.MAX_VALUE);
				heap.add(pair);
				res.put(vce, pair);
			} else {
				DijikstraPair pair = new DijikstraPair(vce, vce, 0);
				heap.add(pair);
				res.put(vce, pair);
			}
		}

		while (!heap.isEmpty()) {
			DijikstraPair process = heap.remove();

			isdone.add(process.vtx);
			for (String key : map.get(process.vtx).keySet()) {
				if (isdone.contains(key)) {
					continue;
				}

				int oldcost = res.get(key).csf;
				int newcost = process.csf + map.get(process.vtx).get(key);

				String psf = process.psf + key;

				if (newcost < oldcost) {

					DijikstraPair pair = new DijikstraPair(key, psf, newcost);
					heap.add(pair);
					res.put(key, pair);
				}

			}

		}

		System.out.println(res);

	}

	// Prims's.=========================================================================================================

	private static class PrimsPair implements Comparable<PrimsPair> {
		private String vtx;
		private String aqvtx;
		private int weight;

		private PrimsPair(String vtx, String aqvtx, int weight) {
			this.vtx = vtx;
			this.aqvtx = aqvtx;
			this.weight = weight;
		}

		@Override
		public int compareTo(PrimsPair o) {
			return this.weight - o.weight;
		}

		@Override
		public String toString() {
			return "(" + this.vtx + "," + this.aqvtx + "," + this.weight + ")";
		}

	}

	private static void Prims() {
		// HashMap<String, PrimsPair> graph = new HashMap<>();
		HashMap<String, HashMap<String, Integer>> graph = new HashMap<>();

		PriorityQueue<PrimsPair> heap = new PriorityQueue<>();
		HashMap<String, PrimsPair> res = new HashMap<>();

		for (String vce : map.keySet()) {
			PrimsPair pair = new PrimsPair(vce, null, Integer.MAX_VALUE);
			heap.add(pair);
			res.put(vce, pair);
		}

		while (!heap.isEmpty()) {
			PrimsPair pair = heap.remove();

			if (!graph.containsKey(pair.vtx)) {
				graph.put(pair.vtx, new HashMap<>());
				// graph.put(pair.vtx, new PrimsPair(pair.vtx, null,
				// Integer.MAX_VALUE));
			}

			if (pair.aqvtx != null) {

				graph.get(pair.vtx).put(pair.aqvtx, pair.weight);
				graph.get(pair.aqvtx).put(pair.vtx, pair.weight);

				// graph.put(pair.vtx, new PrimsPair(pair.vtx, pair.aqvtx,
				// pair.weight));
			}

			for (String key : map.get(pair.vtx).keySet()) {
				if (graph.containsKey(key)) {
					continue;
				}

				PrimsPair OldPair = res.get(key);
				int newcost = map.get(pair.vtx).get(key);

				if (newcost < OldPair.weight) {

					OldPair.aqvtx = pair.vtx;
					OldPair.weight = newcost;

					heap.remove(OldPair);
					heap.add(OldPair);
					res.put(key, OldPair);
				}
			}
		}

		System.out.println(graph);

	}

}
