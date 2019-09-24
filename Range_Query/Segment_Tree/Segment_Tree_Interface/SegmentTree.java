package Segment_Tree;

public class SegmentTree {

	private class Node {

		int data;
		int ssi;
		int sei;
		Node left;
		Node right;

	}

	Node root;

	ISegmentOperator operator;

	public SegmentTree(int[] arr, ISegmentOperator operator) {

		this.operator = operator;
		this.root = construct(arr, 0, arr.length - 1);
	}

	private Node construct(int[] arr, int lo, int hi) {

		if (lo == hi) {
			Node bc = new Node();
			bc.data = arr[lo];
			bc.sei = lo;
			bc.ssi = hi;

			return bc;

		}

		Node node = new Node();

		node.ssi = lo;
		node.sei = hi;

		int mid = (lo + hi) / 2;

		node.left = construct(arr, lo, mid);
		node.right = construct(arr, mid + 1, hi);
		node.data = operator.opertation(node.left.data, node.right.data);

		return node;

	}

	public void display() {

		display(root);

	}

	private void display(Node node) {

		if (node == null) {
			return;
		}

		String str = "";

		str += node.left == null ? "." : node.left.data;
		str += " [ " + node.data + " <- " + node.ssi + " -> " + node.sei + " ] ";
		str += node.right == null ? "." : node.right.data;

		System.out.println(str);

		display(node.left);
		display(node.right);

	}

	public int query(int si, int ei) {
		return query(root, si, ei);
	}

	private int query(Node node, int si, int ei) {

		if (node.ssi >= si && node.sei <= ei) {
			// completely in
			return node.data;

		} else if (node.sei < si || node.ssi > ei) {

			return operator.identity();

		} else {
			int lc = query(node.left, si, ei);
			int rc = query(node.right, si, ei);

			return operator.opertation(lc, rc);
		}

	}

	public void update(int idx, int element) {
		update(root, idx, element);
	}

	public void update(Node node, int idx, int element) {
		if (node.ssi == idx && node.sei == idx) {
			node.data = element;
			return;
		}

		if (idx >= node.ssi && idx <= node.sei) {
			update(node.left, idx, element);
			update(node.right, idx, element);

			node.data = operator.opertation(node.left.data, node.right.data);

		}

	}

	public static void main(String[] args) {

	}

}
