package Tree.BST;

import java.util.LinkedList;

public class BST {

	private class Node {
		private int data;
		private Node left;
		private Node right;
	}

	private Node root;
	private int size;

	// Basic------------------------------------------------------------------------------------------------------------------------------------------

	public BST(int[] pre, int[] in) {

		this.root = construct(pre, in, 0, pre.length - 1, 0, in.length - 1);
	}

	private Node construct(int[] pre, int[] in, int psi, int pei, int isi, int iei) { // psi=pre_statrting_indfex

		if (psi > pei || isi > iei) {
			return null;
		}

		Node node = new Node();
		this.size++;
		node.data = pre[psi];

		int idx = -1;
		for (int i = 0; i < in.length; i++) {
			if (pre[psi] == in[i]) {
				idx = i;
				break;
			}

		}

		int noelonls = idx - isi; // onelonls=Number_of_element_on_left_side.

		node.left = construct(pre, in, psi + 1, psi + noelonls, isi, idx - 1);
		node.right = construct(pre, in, psi + noelonls + 1, pei, idx + 1, iei);

		return node;

	}

	public BST(int[] sa) {
		root = construct(sa, 0, sa.length - 1);
	}

	private Node construct(int[] sa, int lo, int hi) {
		if (lo > hi) {
			return null;
		}
		int mid = (lo + hi) / 2;
		Node node = new Node();
		this.size++;
		node.data = sa[mid];

		node.left = construct(sa, lo, mid - 1);
		node.right = construct(sa, mid + 1, hi);

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
		if (node.left != null) {
			str += node.left.data;
		} else {
			str += ".";
		}

		str += "=>";
		str += node.data;
		str += "<=";

		if (node.right != null) {
			str += node.right.data;
		} else {
			str += ".";
		}

		System.out.println(str);
		display(node.left);
		display(node.right);

	}

	public int size() {
		return this.size;
	}

	public boolean isempty() {
		return this.size == 0;
	}

	// Size2_Max_Min_Height_Find-----------------------------------------------------------------------------------------------------------------------

	public int size2() {
		return size2(root);
	}

	private int size2(Node node) {
		if (node == null) {
			return 0;
		}

		int ls = size2(node.left); // ls=left_size.
		int rs = size2(node.right); // rs=right_size.

		return (ls + rs + 1);

	}

	public int max() {
		if (root != null) {
			return max(root);
		} else {
			System.out.print("Root is null so -infinity of Int is max: ");
			return Integer.MIN_VALUE;
		}

	}

	private int max(Node node) {
		if (node.right != null) {
			return max(node.right);
		} else {
			return node.data;
		}

	}

	public int min() {
		if (root != null) {
			return min(root);
		} else {
			System.out.print("Root is null so +infinity of Int is min: ");
			return Integer.MAX_VALUE;
		}
	}

	public int min(Node node) {

		if (node.left != null) {
			return min(node.left);
		} else {
			return node.data;
		}
	}

	public int height() {
		return height(root);
	}

	public int height(Node node) {
		if (node == null) {
			return -1;
		}

		int lh = height(node.left); // lh=left_height.
		int rh = height(node.right); // rh=right_height.

		return Math.max(lh, rh) + 1;
	}

	public boolean find(int data) {
		return find(root, data);
	}

	public boolean find(Node node, int data) {
		if (node == null) {
			return false;
		}

		if (data > node.data) {
			return find(node.right, data);
		} else if (data < node.data) {
			return find(node.left, data);
		} else {
			return true;
		}

	}

	// Pre_Post_In_LevelOder_display_recursive---------------------------------------------------------------------------------------------------------

	public void preOderDisplay() {
		preOderDisplay(root);
	}

	private void preOderDisplay(Node node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data + ",");
		preOderDisplay(node.left);
		preOderDisplay(node.right);

	}

	public void postOderDisplay() {
		postOderDisplay(root);
	}

	private void postOderDisplay(Node node) {
		if (node == null) {
			return;
		}

		postOderDisplay(node.left);
		postOderDisplay(node.right);
		System.out.print(node.data + ",");
	}

	public void inOderDisplay() {
		inOderDisplay(root);
	}

	private void inOderDisplay(Node node) {
		if (node == null) {
			return;
		}

		inOderDisplay(node.left);
		System.out.print(node.data + ",");
		inOderDisplay(node.right);

	}

	public void levelOrderDisplay() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addFirst(root);

		while (!queue.isEmpty()) {
			Node printable = queue.removeFirst();
			System.out.print(printable.data + ",");

			if (printable.left != null) {
				queue.addLast(printable.left);
			}

			if (printable.right != null) {
				queue.addLast(printable.right);
			}

		}

	}

	// Pre_Post_InOder_display_Iterative---------------------------------------------------------------------------------------------------------------

	private class TraversalPair {
		private Node node;
		private boolean selfdone;
		private boolean leftdone;
		private boolean rightdone;
	}

	public void preOderDisplayIre() {

		LinkedList<TraversalPair> stack = new LinkedList<>();
		TraversalPair pair = new TraversalPair();

		pair.node = root;
		stack.addFirst(pair);

		while (stack.size() != 0) {
			pair = stack.getFirst();

			if (pair.selfdone == false) {
				System.out.print(pair.node.data + ",");

				pair.selfdone = true;
			} else if (pair.leftdone == false) {
				if (pair.node.left != null) {
					TraversalPair lp = new TraversalPair();
					lp.node = pair.node.left;
					stack.addFirst(lp);
				}

				pair.leftdone = true;
			} else if (pair.rightdone == false) {
				if (pair.node.right != null) {
					TraversalPair rp = new TraversalPair();
					rp.node = pair.node.right;
					stack.addFirst(rp);
				}

				pair.rightdone = true;
			} else {
				stack.removeFirst();
			}
		}

	}

	public void postOderDisplayIre() {

		LinkedList<TraversalPair> stack = new LinkedList<>();
		TraversalPair pair = new TraversalPair();
		pair.node = root;
		stack.addFirst(pair);

		while (!stack.isEmpty()) {
			pair = stack.getFirst();

			if (pair.leftdone == false) {
				if (pair.node.left != null) {
					TraversalPair lp = new TraversalPair();
					lp.node = pair.node.left;
					stack.addFirst(lp);
				}

				pair.leftdone = true;
			} else if (pair.rightdone == false) {
				if (pair.node.right != null) {
					TraversalPair lp = new TraversalPair();
					lp.node = pair.node.right;
					stack.addFirst(lp);
				}

				pair.rightdone = true;
			} else if (pair.selfdone == false) {
				System.out.print(pair.node.data + ",");

				pair.selfdone = true;
			} else {
				stack.removeFirst();
			}

		}

	}

	public void inOderDisplayIre() {
		LinkedList<TraversalPair> stack = new LinkedList<>();
		TraversalPair pair = new TraversalPair();
		pair.node = root;
		stack.addFirst(pair);
		while (!stack.isEmpty()) {
			pair = stack.getFirst();

			if (pair.leftdone == false) {
				if (pair.node.left != null) {
					TraversalPair lp = new TraversalPair();
					lp.node = pair.node.left;
					stack.addFirst(lp);
				}

				pair.leftdone = true;
			} else if (pair.selfdone == false) {
				System.out.print(pair.node.data + ",");

				pair.selfdone = true;
			} else if (pair.rightdone == false) {
				if (pair.node.right != null) {
					TraversalPair lp = new TraversalPair();
					lp.node = pair.node.right;
					stack.addFirst(lp);
				}

				pair.rightdone = true;
			} else {
				stack.removeFirst();
			}

		}

	}

	// Add_remove_replace_printBetweenRangeAndThereVariations_and_Siblings_type_functions--------------------------------------------------------------

	public void add(int data) {
		add(root, data);
	}

	private void add(Node node, int data) {

		if (data > node.data) {
			if (node.right == null) {
				Node nn = new Node();
				nn.data = data;
				node.right = nn;
				this.size++;
			} else {
				add(node.right, data);
			}
		} else if (data < node.data) {
			if (node.left == null) {
				Node nn = new Node();
				nn.data = data;
				node.left = nn;
				this.size++;
			} else {
				add(node.left, data);
			}
		}

	}

	public void remove(int data) {
		if (root == null) {
			return;
		} else {
			remove(data, root, null, false);
		}
	}

	private void remove(int data, Node node, Node parent, boolean ilc) {
		if (data > node.data) {
			remove(data, node.right, node, false);
		} else if (data < node.data) {
			remove(data, node.left, node, true);
		} else {
			if (node.left != null && node.right != null) {
				node.data = this.max(node.left);
				remove(node.data, node.left, node, true);

			} else {
				this.size--;
				if (ilc) {
					parent.left = (node.left != null) ? node.left : node.right;
				} else {
					parent.right = (node.left != null) ? node.left : node.right;
				}
			}
		}
	}

	public void removeAllLeaves() {
		removeAllLeaves(root, null, false);
	}

	private void removeAllLeaves(Node node, Node parent, boolean ilc) {
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			if (ilc) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		}

		removeAllLeaves(node.left, parent, true);
		removeAllLeaves(node.right, parent, false);

	}

	public void printNodeWithoutSublings() {
		printNodeWithoutSublings(root);
	}

	private void printNodeWithoutSublings(Node node) {

		if (node.left == null && node.right != null) {
			System.out.println(node.data);
		} else if (node.right == null && node.left != null) {
			System.out.println(node.data);
		} else if (node.left != null && node.right != null) {
			printNodeWithoutSublings(node.left);
			printNodeWithoutSublings(node.right);
		}

	}

	public void printSiblings() {
		this.printSiblings(null, this.root, false);
	}

	private void printSiblings(Node parent, Node node, boolean ilc) {
		if (node.left == null && node.right != null) {
			System.out.println(parent.right.data);
		} else if (node.right == null && node.left != null) {
			System.out.println(parent.left.data);
		} else if (node.left != null && node.right != null) {
			printSiblings(node, node.left, true);
			printSiblings(node, node.right, false);
		}
	}

	public void printBetweenRange(int lodata, int hidata) {
		printBetweenRange(root, lodata, hidata);
	}

	private void printBetweenRange(Node node, int lodata, int hidata) {

		if (lodata > node.data) {
			printBetweenRange(node.right, lodata, hidata);
		} else if (hidata < node.data) {
			printBetweenRange(node.left, lodata, hidata);
		} else {

			System.out.println(node.data + " ");
			printBetweenRange(node.left, lodata, hidata);
			printBetweenRange(node.right, lodata, hidata);
		}

	}

	private class HeapMover_sum {
		int sum;
	}

	public void replaceWithSumOfLarerNode() {
		HeapMover_sum bucket = new HeapMover_sum();
		replaceWithSumOfLarerNode(bucket, root);
	}

	// Add_all_greater_values_to_every_node
	private void replaceWithSumOfLarerNode(HeapMover_sum bucket, Node node) {
		if (node == null) {
			return;
		}

		replaceWithSumOfLarerNode(bucket, node.right);
		bucket.sum += node.data;
		node.data = bucket.sum;
		replaceWithSumOfLarerNode(bucket, node.left);

	}

	// Is_BST_and_there_Variations.

	private class HM_isbst { // HeapMover_IsBST.
		private int max;
		private int min;
		private boolean isbst;
		private int sbc; // sbc=subBSTCount.
		private int colbstinb; // count_of_largestBST_in_branch.
		private Node largestBSTRoot;

	}

	public void isBstcount() {
		isBstVariastionTCount(root);

	}

	private HM_isbst isBstVariastionTCount(Node node) {
		if (node == null) {
			HM_isbst rp = new HM_isbst();
			rp.max = Integer.MIN_VALUE;
			rp.min = Integer.MAX_VALUE;
			rp.isbst = true;
			rp.colbstinb = 0;
			rp.largestBSTRoot = null;

			return rp;
		}

		HM_isbst leftpair = isBstVariastionTCount(node.left);
		HM_isbst rightpair = isBstVariastionTCount(node.right);

		HM_isbst np = new HM_isbst();

		np.max = Math.max(Math.max(leftpair.max, rightpair.max), node.data);
		np.min = Math.min(Math.min(leftpair.min, rightpair.min), node.data);

		if (leftpair.isbst && rightpair.isbst && node.data < leftpair.min && node.data > rightpair.max) {
			np.isbst = true;
			np.colbstinb = leftpair.colbstinb + rightpair.colbstinb + 1;
			np.largestBSTRoot = node;
		} else {
			np.isbst = false;
			if (leftpair.colbstinb > rightpair.colbstinb) {
				np.colbstinb = leftpair.colbstinb;
				np.largestBSTRoot = leftpair.largestBSTRoot;
			} else {
				np.colbstinb = rightpair.colbstinb;
				np.largestBSTRoot = rightpair.largestBSTRoot;
			}
		}
		return np;

	}

}
