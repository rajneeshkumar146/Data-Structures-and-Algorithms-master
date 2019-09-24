package Tree.SegmentTree.SumOfGivenRange;

public class SegmentTreeNode {

	private class Node {
		private long data;
		private int si;
		private int ei;
		private Node left;
		private Node right;
	}

	private Node root;
	private int size;

	public SegmentTreeNode(int[] arr) {
		root = construct(arr, 0, arr.length - 1);

	}

	private Node construct(int[] arr, int si, int ei) {
		if (si == ei) {
			Node rn = new Node();
			rn.data = arr[si];
			rn.si = rn.ei = si;
			this.size++;
			return rn;
		}

		Node node = new Node();
		int mid = (si + ei) / 2;
		node.si = si;
		node.ei = ei;

		node.left = construct(arr, si, mid);
		node.right = construct(arr, mid + 1, ei);

		node.data = node.left.data + node.right.data;
		return node;
	}

	// General_Functions-------------------------------------------------------------------------------------------------------------------

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void displayy() {
		display(root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";
		if (node.left != null) {
			str += node.left.data;
		} else {
			str += ".";
		}

		str += " => " + node.data + " <= ";
		if (node.right != null) {
			str += node.right.data;
		} else {
			str += ".";
		}

		System.out.println(str);
		display(node.left);
		display(node.right);
	}

	// Query_and_Update----------------------------------------------------------------------------------------------------------------------

	public long query(int i, int j) {
		return query(root, i, j);
	}

	private long query(Node node, int i, int j) {
		if (node == null) {
			return 0;
		}

		if (node.si >= i && node.ei <= j) {
			return node.data;
		} else if (node.si > j || node.ei < i) {
			return 0;
		} else {
			return query(node.left, i, j) + query(node.right, i, j);
		}
	}

	public void update(int i, int delta) {
		update(root, i, delta);
	}

	private void update(Node node, int i, int delta) {
		if (node.si == i && node.ei == i) {
			node.data += delta;
			return;
		}

		if (i <= node.left.ei && i >= node.left.si) { // agar_vo_bich_mai_lie_krta_hai_to_call_lagado.
			update(node.left, i, delta);
		} else if (i >= node.right.si && i <= node.right.ei) {
			update(node.right, i, delta);
		}

		node.data = node.left.data + node.right.data;
		return;
	}

}