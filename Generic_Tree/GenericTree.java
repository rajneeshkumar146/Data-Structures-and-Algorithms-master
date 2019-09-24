package Tree.GenericTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GenericTree {

	private class Node {
		private int data;
		private ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;
	private int size = 0;

	GenericTree() {
		Scanner scn = new Scanner(System.in);
		root = takeinput(null, -1, scn);
	}

	private Node takeinput(Node parent, int children, Scanner scn) {
		// prompt
		if (parent == null) {
			System.out.println("Entre Data For Root.");
		} else {
			System.out.println("Entre Data For" + children);
		}

		// collect data
		int data = scn.nextInt();

		// create node,set data and maintain size

		Node node = new Node();
		node.data = data;
		this.size++;

		// solve the same problem for children-ask number of children for child
		System.out.println("Entre No children for" + node.data + "th parent");
		int noc = scn.nextInt();

		for (int i = 0; i < noc; i++) {
			Node gchild = takeinput(node, i, scn);
			node.children.add(gchild);
		}

		return node;
	}

	// General_functions--------------------------------------------------------------------

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return (this.size == 0);
	}

	public int SizeRec() {
		return SizeRec(root);
	}

	private int SizeRec(Node node) {
		if (node == null) {
			return 0;
		}

		int rsize = 0; // real_size.
		for (Node child : node.children) {
			rsize += SizeRec(child);
		}

		rsize += 1;
		return rsize;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int max = node.data;
		for (Node child : node.children) {
			int tmax = max(child);
			if (tmax > max) {
				max = tmax;
			}
		}

		return max;
	}

	public boolean find(int data) {
		return find(root, data);
	}

	private boolean find(Node node, int data) {
		if (node.data == data) {
			return true;
		}

		for (Node child : node.children) {
			if (find(child, data) == true) {
				return true;
			}
		}

		return false;
	}

	public int hight() {
		return hight(root);
	}

	private int hight(Node node) {
		if (node == null) {
			return -1;
		}
		int hei = -1;
		for (Node child : node.children) {
			int chei = hight(child);
			if (chei > hei) {
				hei = chei;
			}
		}

		return hei + 1;
	}

	// Display-----------------------------------------------------------------------------------

	public void display() {
		display(root);
		System.out.println();
	}

	private void display(Node node) {
		String str = node.data + "=>";
		for (Node child : node.children) {
			str += child.data + ",";
		}
		System.out.println(str);
		for (Node child : node.children) {
			display(child);
		}

	}

	public void preDisplay() {
		preDisplay(root);
	}

	private void preDisplay(Node node) {
		System.out.print(node.data + ",");
		for (Node child : node.children) {
			preDisplay(child);
		}

	}

	public void postDisplay() {
		postDisplay(root);
	}

	private void postDisplay(Node node) {
		for (Node child : node.children) {
			postDisplay(child);
		}
		System.out.print(node.data + ",");
	}

	public void LevelOderDisplay() {
		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			Node oper = q.poll(); // Operation.
			System.out.print(oper.data + ",");

			q.addAll(oper.children);

		}
		System.out.println();

	}

	public void LevelOderLinerwiseDisplay() {
		Queue<Node> q1 = new LinkedList<>();
		Queue<Node> q2 = new LinkedList<>();

		q1.add(root);

		while (!q1.isEmpty()) {
			Node oper = q1.poll(); // Operation.
			System.out.print(oper.data + ",");
			q2.addAll(oper.children);

			if (q1.isEmpty()) {
				q1 = q2;
				q2 = new LinkedList<>();
				System.out.println();
			}

		}
		System.out.println();

	}

	// Mirror_Image-----------------------------------------------------------------------------------------

	public void mirrorImage() {
		MirrorImage(root);
	}

	private void MirrorImage(Node node) {

		int le = 0; // left
		int ri = node.children.size() - 1; // right
		while (le < ri) {
			Node ln = node.children.get(le); // Left_Node.
			Node rn = node.children.get(ri); // Right_Node.
			node.children.set(le, rn);
			node.children.set(ri, ln);
			le++;
			ri--;

		}

		for (Node child : node.children) {
			MirrorImage(child);
		}

	}

	// print_at_Depth

	public void printAtDepth(int d) {

		printAtDepth(root, d, 0);

	}

	private void printAtDepth(Node node, int d, int i) {
		for (Node child : node.children) {
			printAtDepth(child, d, i + 1);
			if (d == i) {
				System.out.print(child.data + ",");
			}
		}

	}

	// Heap_Mover_and_Multi_solver.

	private class HeapMover {

		private int size;
		private boolean found;
		private int max = Integer.MIN_VALUE;
		private int min = Integer.MAX_VALUE;
		private int height = 0;

		private Node prev;
		private Node curr;

		private Node succ;
		private Node pred;
		private Node jl;

		private ArrayList<Node> child = new ArrayList<>();

	}

	public void multiSolver(int data) {
		HeapMover hp = new HeapMover();
		multiSolver(root, hp, data, 0);
	}

	private void multiSolver(Node node, HeapMover hp, int data, int depth) {
		hp.prev = hp.curr;
		hp.curr = node;

		hp.size++;

		if (hp.found == true && hp.succ == null) {
			hp.succ = hp.curr;
		}

		if (node.data == data) {
			hp.found = true;
			hp.pred = hp.prev;
		}

		if (node.data > hp.max) {
			hp.max = node.data;
		}

		if (node.data < hp.min) {
			hp.min = node.data;
		}

		if (depth > hp.height) {
			hp.height = depth;
		}

		if (node.data > data) {
			if (hp.jl == null) {
				hp.jl = node;
			} else if (node.data < hp.jl.data) {
				hp.jl = node;
			}
		}

		for (Node child : node.children) {
			multiSolver(child, hp, data, depth + 1);
		}

	}

	// Remove_Leaves,Linearize_and_flattern---------------------------------------------------------------------------------------

	public void removeLeaves() {
		removeLeaves(root);

	}

	private void removeLeaves(Node node) {

		for (int i = node.children.size() - 1; i >= 0; i--) {

			Node access = node.children.get(i);
			if (access.children.size() == 0) {
				node.children.remove(i);
			}

		}

		for (Node child : node.children) {
			removeLeaves(child);
		}
	}

	public void linearize() {
		linearize(root);
	}

	private Node linearize(Node node) {
		if (node.children.size() == 0) {
			return node;
		}

		Node tail = null;
		for (Node child : node.children) {
			if (tail != null) {
				tail.children.add(child);
			}
			tail = linearize(child);
		}

		while (node.children.size() > 1) {
			node.children.remove(node.children.size() - 1);
		}

		return tail;

	}

	public void linearizebtr() {
		HeapMover hp = new HeapMover();
		hp.curr = new Node();
		hp.curr.data = root.data;
		Node temp = hp.curr;
		linearizebtr(root, hp);
		root = temp;
	}

	private void linearizebtr(Node node, HeapMover hp) {
		if (node != root) {
			hp.prev = hp.curr;
			hp.curr = new Node();
			hp.curr.data = node.data;
			hp.prev.children.add(hp.curr);
		}

		for (Node child : node.children) {
			linearizebtr(child, hp);
		}

		node.children.clear();

	}

	public void flatten() {
		flatten(root);
	}

	private void flatten(Node node) {
		if (node.children.size() == 0) {
			return;
		}

		for (Node child : node.children) {
			flatten(child);

		}

		ArrayList<Node> ncl = new ArrayList<>();
		for (Node child : node.children) {
			ncl.add(child);
			ncl.addAll(child.children);
			child.children.clear();
		}

		node.children = ncl;
	}

	public void flatternBtr() {
		HeapMover hp = new HeapMover();
		flatternBtr(this.root, hp);
		root.children.addAll(hp.child);
	}

	private void flatternBtr(Node node, HeapMover hp) {
		if (node != this.root) {
			hp.child.add(node);
		}

		for (Node child : node.children) {
			flatternBtr(child, hp);
		}

		node.children.clear();
		return;

	}

	// KthSmallest_and_iso

	public int KthSmallest(int k) {

		int data = Integer.MIN_VALUE;
		for (int i = 0; i < k; i++) {
			HeapMover hp = new HeapMover();
			KthSmallest(root, data, hp);
			data = hp.jl.data;
		}
		return data;

	}

	private void KthSmallest(Node node, int data, HeapMover hp) {

		if (node.data > data) {
			if (hp.jl == null) {
				hp.jl = node;
			} else if (node.data < hp.jl.data) {
				hp.jl = node;

			}
		}

		for (Node child : node.children) {
			KthSmallest(child, data, hp);
		}
	}

	public int KthSmallestBtr(int k) {
		ArrayList<Integer> list = new ArrayList<>();
		KthSmallestBtr(root, list);
		Collections.sort(list);
		return list.get(k - 1);

	}

	private void KthSmallestBtr(Node node, ArrayList<Integer> list) {

		list.add(node.data);

		for (Node child : node.children) {
			KthSmallestBtr(child, list);
		}
	}

	public boolean isomorphic(GenericTree other) {
		return isomorphic(this.root, other.root);
	}

	private boolean isomorphic(Node tnode, Node onode) {

		if (tnode.children.size() != onode.children.size()) {
			return false;
		}
		for (int i = 0; i < onode.children.size(); i++) {
			Node tn = tnode.children.get(i);
			Node on = onode.children.get(i);
			boolean result = isomorphic(tn, on);
			if (result == false) {
				return false;
			}
		}

		return true;
	}

	public boolean ismirroriso() {
		return ismirroiso(root, root);
	}

	private boolean ismirroiso(Node lmnode, Node rmnode) {
		if (lmnode.children.size() != rmnode.children.size()) {
			return false;
		}

		for (int i = 0; i < lmnode.children.size(); i++) {
			Node lmchild = lmnode.children.get(i);
			Node rmchild = rmnode.children.get(rmnode.children.size() - i - 1);
			boolean result = ismirroiso(lmchild, rmchild);
			if (result == false) {
				return false;
			}
		}

		return true;
	}

	private class kaway {
		private boolean isfind;
		private int data;
		private int kaway;
		private int mDepth; // moveabledepth.
		HashMap<Node, Boolean> isdone = new HashMap<Node, Boolean>();
	}

	public void kaway(int data, int k) {
		kaway hm = new kaway();
		hm.kaway = k;
		hm.data = data;
		kaway(root, hm);

	}

	private void kaway(Node node, kaway hm) {
		if (node.data == hm.data) {
			hm.isfind = true;
		}

		if (hm.isfind && hm.kaway == hm.mDepth) {
			System.out.println(node.data);
		}

		if (hm.isfind) { // Depth_Move_Downwared
			hm.mDepth++;
		}
		for (Node child : node.children) {

			if (hm.isfind && hm.mDepth > hm.kaway) {
				return;
			} else if (!hm.isdone.containsKey(child)) {
				kaway(child, hm);
			} else {
				continue;
			}

			if (hm.isfind) {// Depth_Move_Upward
				hm.mDepth--;
			}

			if (hm.isfind && child.data == hm.data) { // reset_all_data.
				hm.mDepth = 0;
				hm.kaway--;
				hm.data = node.data;
				hm.isdone.put(child, true);
				kaway(node, hm);
				break;
			}

		}
	}

}
