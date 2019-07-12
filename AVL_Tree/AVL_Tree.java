package AVL_Tree;

public class AVL_Tree {

	private class Node {
		int data;
		int ht;
		int bal;
		Node right;
		Node left;

	}

	private Node root;
	private int size = 0;

	public AVL_Tree(int[] arr) {
		root = construct(arr, 0, arr.length - 1);
	}

	private Node construct(int[] arr, int lo, int hi) {

		if (lo > hi) {

			return null;
		}

		int mid = (lo + hi) / 2;

		Node node = new Node();

		node.data = arr[mid];

		size++;

		node.left = construct(arr, lo, mid - 1);

		node.right = construct(arr, mid + 1, hi);

		setHnB(node);

		return node;

	}

	private void setHnB(Node node) {
		int lh = node.left == null ? 0 : node.left.ht;
		int rh = node.right == null ? 0 : node.right.ht;

		node.ht = Math.max(lh, rh) + 1;
		node.bal = lh - rh;

	}

	public void display() {

		display(root);

	}

	private void display(Node node) {

		if (node == null) {
			return;
		}
		String str = new String();

		str += node.left != null ? node.left.data : ".";

		str += "<- " + node.data + "[" + node.ht + "|" + node.bal + "]" + " -> ";

		str += node.right != null ? node.right.data : ".";

		System.out.println(str);

		display(node.left);
		display(node.right);

	}

}
