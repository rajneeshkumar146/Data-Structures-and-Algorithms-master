package SquareRoot_Decomposition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class LCA_of_Tree_in_OsqrHeight_time_By_Array {
	public static Scanner scn = new Scanner(System.in);
	private HashMap<Integer, HashSet<Integer>> tree = new HashMap<>();
	private int[] depth;
	private int[] parent;
	private int[] jumpParent;
	private int ClusterSize;
	private int root = Integer.MIN_VALUE;

	public void AddEdge(int u, int v) {
		if (tree.get(u) == null) {
			tree.put(u, new HashSet<>());
		}

		if (root == Integer.MIN_VALUE) {
			root = u;
		}

		tree.get(u).add(v);
	}

	public int height() {
		return height(this.root);
	}

	private int height(int u) {
		if (tree.get(u).isEmpty()) {
			return -1;
		}

		int Maxheight = -1;
		ArrayList<Integer> keys = new ArrayList<>(this.tree.get(u));
		for (Integer key : keys) {
			int height = height(key);
			Maxheight = Math.max(height, Maxheight)+1;
		}

		return Maxheight;
	}

	public void preprocess() {
		this.ClusterSize = (int) Math.ceil(Math.sqrt(height(this.root)));
		this.depth[0] = -1;

		// precalclating_1)depth._2)parent._3)jump_parent_for each node.

		dfs(root, 0);

	}

	private void dfs(int curr, int prev) {

		this.depth[curr] = depth[prev] + 1;
		this.parent[curr] = prev;

		if (depth[curr] % ClusterSize == 0) {
			jumpParent[curr] = prev;
		} else {
			jumpParent[curr] = jumpParent[prev];
		}

		ArrayList<Integer> keys = new ArrayList<>(this.tree.get(curr));
		for (Integer key : keys) {
			dfs(key, curr);
		}

	}

	public int LCASQRT(int u, int v) {
		
		while(jumpParent[u]!=jumpParent[v]){
			if(depth[u]>depth[v]){
				int temp=u;
				u=v;
				v=temp;
			}
			
			v=jumpParent[v];
		}
		
		return LCANaive(u, v);

	}

	private int LCANaive(int u, int v) {
		if (u == v) {
			return u;
		}

		if (depth[u] > depth[v]) {
			int temp = u;
			u = v;
			v = temp;
		}
		v = parent[v];
		
		return LCANaive(u, v);

	}

	public static void main(String[] args) throws Exception {

	}

}
