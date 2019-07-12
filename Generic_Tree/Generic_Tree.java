package Generic_Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class Generic_Tree {

	private class Node {

		int data;

		ArrayList<Node> children = new ArrayList<>();

	}
	
	Node root;
	private int size;

	public Generic_Tree(int[] arr) {

		Stack<Node> stack = new Stack<>();

		for (int val : arr) {

			if (val != -1) {
				Node node = new Node();
				size++;
				node.data = val;

				if (stack.size() == 0) {
					root = node;

				} else {
					stack.peek().children.add(node);

				}

				stack.push(node);

			} else {
				stack.pop();

			}

		}
	}

	public int size() {
		return size;

	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void display() {

		display(root);

	}

	private void display(Node node) {

		String str = node.data + " -> ";

		for (Node child : node.children) {
			str += child.data + " . ";
		}

		System.out.println(str);

		for (Node child : node.children) {
			display(child);
		}
	}

	public int sizer() {

		return sizer(root);

	}
	
	private int sizer(Node node) {
		
		int size = 0;

		for (Node child : node.children) {
			int cfsize = sizer(child);

			size += cfsize;
		}

		size += 1;

		return size;

	}

	public int max() {

		return max(root);

	}

	private int max(Node node) {
		int max = node.data;
		
		for (Node child : node.children) {
		
			int cm = max(child);
			
			max = cm > max ? cm : max;
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

			boolean ans = find(child, data);
			if (ans == true) {
				return true;
			}
		}

		return false;

	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		int height = 0;
		int max = 0;

		for (Node child : node.children) {
			int cfheight = height(child);

			height = cfheight;

			max = height > max ? height : max;
		}

		height += 1;

		return max + 1;

	}

   	public ArrayList<Integer> nodeToRootPath(int data) {
		return nodeToRootPath(root, data);
	}

	private ArrayList<Integer> nodeToRootPath(Node node, int data) {

		ArrayList<Integer> list = new ArrayList<>();

		if (node.data == data) {
			list.add(node.data);

			return list;
		}

		for (Node child : node.children) {

			list = nodeToRootPath(child, data);

			if (list.size() > 0) {
				list.add(node.data);

				return list;
			}
		}

		return list;

	}

	public int LCA(int t1, int t2) {

		ArrayList<Integer> l1 = nodeToRootPath(t1);

		ArrayList<Integer> l2 = nodeToRootPath(t2);

		int i = l1.size() - 1;
		int j = l2.size() - 1;

		while (true) {

			if (l1.get(i) != l2.get(j)) {
				return l1.get(i + 1);

			}
			i--;
			j--;
		}

	}

	public int distanceBTWnode(int t1, int t2) {
		ArrayList<Integer> l1 = nodeToRootPath(t1);

		ArrayList<Integer> l2 = nodeToRootPath(t2);

		int ctr = 0;

		int i = l1.size() - 1;
		int j = l2.size() - 1;

		while (true) {

			if (l1.get(i) != l2.get(j)) {

				return l1.size() + l2.size() - 2 * ctr;
			}
			i--;
			j--;

			ctr++;
		}

	}

	public int distanceBTWnode_2(int t1, int t2) { // EASY

		ArrayList<Integer> l1 = nodeToRootPath(t1);

		ArrayList<Integer> l2 = nodeToRootPath(t2);

		int x = LCA(t1, t2);

		ArrayList<Integer> l3 = nodeToRootPath(x);

		int dist = (l1.size() + l2.size()) - 2 * l3.size();

		return dist;

	}

	public void mirror() {
		mirror(root);
	}

	private void mirror(Node node) {

		Collections.reverse(node.children);

		for (Node child : node.children) {

			mirror(child);
		}
	}

	public void removeLeaves() {
		removeLeaves(root);
	}

	private void removeLeaves(Node node) {

		for (int i = node.children.size() - 1; i >= 0; i--) {
			Node child = node.children.get(i);
			{
				if (child.children.size() == 0) {
					node.children.remove(i);

				}

				removeLeaves(child);

			}

		}
	}

	public void preOrder() {

		preOrder(root);

	}

	private void preOrder(Node node) {

		System.out.print(node.data + " ");

		for (Node child : node.children) {

			preOrder(child);
		}

	}

	public void postOrder() {

		postOrder(root);

	}

	private void postOrder(Node node) {

		for (Node child : node.children) {

			postOrder(child);
		}

		System.out.print(node.data + " ");

	}

	public void printKthLevel(int k) {
		printKthLevel(root, k, 0);
	}

	private void printKthLevel(Node node, int k, int ctr) {

		if (ctr == k) {
			System.out.print(node.data + " ");

			return;
		}

		for (Node child : node.children) {

			printKthLevel(child, k, ctr + 1);

		}

	}

	public void levelOrder() {

		LinkedList<Node> queue = new LinkedList<Node>();

		queue.addLast(root);

		while (queue.size() > 0) {

			Node temp = queue.removeFirst();

			System.out.print(temp.data + " ");

			for (Node node : temp.children) {

				queue.addLast(node);

			}
		}

	}

	public void levelOrderLineWise() { // 1 . NULL in queue ----2 . Dual Queue method *

		LinkedList<Node> queue = new LinkedList<Node>();
		LinkedList<Node> nextqueue = new LinkedList<Node>();

		queue.addLast(root);

		while (queue.size() > 0) {

			Node temp = queue.removeFirst();

			System.out.print(temp.data + " ");

			for (Node node : temp.children) {

				nextqueue.addLast(node);
			}

			if (queue.size() == 0) {

				System.out.println();

				queue = nextqueue;

				nextqueue = new LinkedList<>();
			}

		}

	}

	public void spiralLevelOrder() {

		LinkedList<Node> curr = new LinkedList<>();
		LinkedList<Node> last = new LinkedList<>();

		curr.addLast(root);
		boolean turner = true;

		while (curr.size() > 0) {

			Node temp = curr.removeFirst();

			System.out.print(temp.data + " ");

			if (turner) {
				for (Node child : temp.children) {
					last.addFirst(child);
				}
			} else {
				for (int i = temp.children.size() - 1; i >= 0; i--) {
					Node child = temp.children.get(i);
					last.addFirst(child);
				}
			}

			if (curr.size() == 0) {
				System.out.println();

				curr = last;

				last = new LinkedList<>();

				turner = !turner;
			}

		}

	}

	public void spiralLevelOrder_prec() {

		LinkedList<Node> curr = new LinkedList<>();

		LinkedList<Node> next = new LinkedList<>();

		curr.add(root);

		boolean turner = true;

		while (curr.size() > 0) {
			Node temp = curr.removeFirst();

			System.out.print(temp.data + " ");

			if (turner) {
				for (Node child : temp.children) {

					next.addFirst(child);

				}

			} else {
				for (int i = temp.children.size() - 1; i >= 0; i--) {

					Node node = temp.children.get(i);

					next.addFirst(node);
				}

			}

			if (curr.size() == 0) {
				System.out.println();
				curr = next;
				next = new LinkedList<>();

				turner = !turner;

			}
		}

	}

	public void linearize() {

		linearize(root);

	}

	public Node getTail(Node node) {

		if (node.children.size() == 0) {

			return node;

		} else {

			return getTail(node.children.get(0));

		}

	}

	private void linearize(Node node) {

		for (Node child : node.children) {
			linearize(child);
		}

		while (node.children.size() > 1) {
			Node last = node.children.remove(node.children.size() - 1);

			Node Slast = getTail(node.children.get(node.children.size() - 1));

			Slast.children.add(last);

		}

	}

	public void linearize_Better() {

		linearize_better(root);

	}

	private Node linearize_better(Node node) {

		if (node.children.size() == 0) {

			return node;
		}

		Node otail = linearize_better(node.children.get(node.children.size() - 1));

		for (int i = node.children.size() - 2; i >= 0; i--) {
			Node temp = linearize_better(node.children.get(i));

			temp.children.add(node.children.remove(i + 1));

		}
		return otail;

	}

	public boolean isMorphic(Generic_Tree other) {

		return isMorphic(this.root, other.root);
	}

	public boolean isMorphic(Node thisnode, Node othernode) {

		if (thisnode.children.size() != othernode.children.size()) {
			return false;
		}

		for (int i = 0; thisnode.children.size() - 1 > 0; i++) {

			Node n = thisnode.children.get(i);

			Node o = othernode.children.get(i);

			if (!isMorphic(n, o)) {
				return false;
			}
		}
		return true;

	}

	public boolean isMirrorImage(Generic_Tree other) {

		return isMirrorImage(this.root, other.root);
	}

	private boolean isMirrorImage(Node thisnode, Node othernode) {

		if (thisnode.children.size() != othernode.children.size()) {
			return false;
		}

		for (int i = 0; thisnode.children.size() - 1 > 0; i++) {

			Node n = thisnode.children.get(i);

			Node o = othernode.children.get(othernode.children.size() - i);

			if (!isMirrorImage(n, o)) {
				return false;
			}
		}
		return true;
	}

	public boolean isSymetric(Generic_Tree other) {

		return isSymetric(this.root, other.root);
	}

	private boolean isSymetric(Node thisnode, Node othernode) { // Should be isMirror of itself

		return true;
	}

	public void multiSolver(int data) {
		multiSolver(root, data, 0);

		System.out.println("Size = " + size);
		System.out.println("Height = " + heightMS);
		System.out.println("Min = " + minMS);
		System.out.println("Max =" + maxMS);

	}

	private int sizeMS = 0;
	private int heightMS = 0;
	private int minMS = Integer.MAX_VALUE;
	private int maxMS = Integer.MIN_VALUE;
	Boolean find = false;

	public void multiSolver(Node node, int data, int depth) {

		sizeMS++;
		heightMS = Math.max(heightMS, depth);
		minMS = Math.min(minMS, node.data);
		maxMS = Math.max(maxMS, node.data);
		find = find || node.data == data;

		for (Node child : node.children) {

			multiSolver(child, data, depth + 1);

		}

	}

}
