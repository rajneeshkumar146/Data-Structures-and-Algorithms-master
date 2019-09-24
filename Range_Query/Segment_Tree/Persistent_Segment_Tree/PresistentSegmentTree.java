package Tree.SegmentTree.PersistentSegmentTree;

public class PresistentSegmentTree {

	private class Node {
		private long data;
		private int si;
		private int ei;
		private Node left;
		private Node right;
	}

	private final Node[] rootList = new Node[100];
	private Node root;
	private int size;

	public PresistentSegmentTree(int[] arr) {
		root = construct(arr, 0, arr.length - 1);
		rootList[0] = root;

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

	public void display(int version) {
		display(rootList[version]);
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

	public long query(int version, int i, int j) {
		return query(rootList[version], i, j);
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

	public void update(int version, int i, int delta) {
		rootList[version] = update(rootList[version - 1], i, delta);
	}

	private Node update(Node node, int i, int delta) {
		if (node.si == i && node.ei == i) {
			Node nnode = new Node();
			nnode.data = node.data + delta;
			nnode.si = node.si;
			nnode.ei = node.ei;
			return nnode;
		}

		Node child = new Node();
		child.ei = node.ei;
		child.si = node.si;
		if (i <= node.left.ei && i >= node.left.si) { // agar_vo_bich_mai_lie_krta_hai_to_call_lagado.
			child.left = update(node.left, i, delta);
			child.right = node.right;
		} else if (i >= node.right.si && i <= node.right.ei) {
			child.right = update(node.right, i, delta);
			child.left = node.left;
		}

		child.data = child.left.data + child.right.data;

		return child;
	}

}