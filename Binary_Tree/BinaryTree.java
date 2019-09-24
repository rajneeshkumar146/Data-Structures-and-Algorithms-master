package Tree.BInaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import org.w3c.dom.Node;

public class BinaryTree {

	private class Node {
		private Node left;
		private Node right;
		private int data;
	}

	private Node root;
	private int size;

	public BinaryTree() {
		Scanner scn = new Scanner(System.in);
		this.root = takeinput(null, false, scn);

	}

	public Node takeinput(Node parent, boolean ilc, Scanner scn) {
		// prompt
		if (parent == null) {
			System.out.println("Entre Data for Root");
		} else {
			System.out.format("Enter data for %s for" + parent.data + "%n", ilc ? "Left Child" : "right Child");
		}

		// Set_Data
		int data = scn.nextInt();
		Node node = new Node();
		node.data = data;
		this.size++;

		System.out.println("Do you have a left Child: ");
		Boolean hlc = scn.nextBoolean();
		if (hlc) {
			node.left = takeinput(node, true, scn);
		}

		System.out.println("Do you have a right child: ");
		boolean hrc = scn.nextBoolean();
		if (hrc) {
			node.right = takeinput(node, false, scn);
		}

		return node;

	}

	// Generl_Functions.

	public int size() {
		return this.size;
	}

	public int size2() {
		return size2(root);
	}

	private int size2(Node node) {
		if (node == null) {
			return 0;
		}

		int lc = size2(node.left);
		int rc = size2(node.right);

		return lc + rc + 1;
	}

	public boolean IsEmpty() {
		return (this.size == 0);
	}

	public void clear() {
		this.root = null;
	}

	// Size2_Max_Min_Height_Find------------------------------------------------------------------------------------------------

	public boolean find(int data) {
		return find(root, data);
	}

	private boolean find(Node node, int data) {

		if (node == null) {
			return false;
		}

		if (node.data == data) {
			return true;
		}

		boolean inlb = find(node.left, data); // In_Left_branch.
		if (inlb == true) {
			return true;
		}
		boolean inrb = find(node.right, data);// In_Right_branch.
		if (inrb == true) {
			return true;
		}
		return false;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}
		int milb = max(node.left);// max_in_left_branch.
		int mirb = max(node.right);// Max_In_right_branch.

		return Math.max(Math.max(milb, mirb), node.data);
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}
		int holb = height(node.left);// height_of_left_branch.
		int horb = height(node.right);// height_of_right_branch.

		return Math.max(holb, horb) + 1;
	}

	public int diameter() { // O(n^2).

		return diameter(root);
	}

	private int diameter(Node node) {
		if (node == null) {
			return 0;
		}

		int dl = diameter(node.left);
		int dr = diameter(node.right);

		int hl = height(node.left);
		int hr = height(node.right);

		int f1 = hl + hr + 2;
		return Math.max(Math.max(dl, dr), f1);
	}

	private class DiaPair {
		private int height;
		private int diameter;
	}

	public int diameter2() {
		return diameter2(root).diameter;
	}

	private DiaPair diameter2(Node node) {
		if (node == null) {
			DiaPair tdia = new DiaPair();
			tdia.height = -1;
			tdia.diameter = 0;
			return tdia;
		}
		DiaPair dl = diameter2(node.left);
		DiaPair dr = diameter2(node.right);

		int f1 = dl.height + dr.height + 2;
		DiaPair dp = new DiaPair();
		dp.diameter = f1;
		dp.height = Math.max(dl.height, dr.height) + 1;
		return dp;

	}


	// Display---------------------------------------------------------------------------------------

	public void display() {
		display(root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}
		String str = new String();
		if (node.left != null) {
			str += node.left.data;
		} else {
			str += ".";
		}

		str += "=>" + node.data + "<=";

		if (node.right != null) {
			str += node.right.data;
		} else {
			str += ".";
		}

		System.out.println(str);

		display(node.left);
		display(node.right);

	}

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

		System.out.print(node.data + ",");
		postOderDisplay(node.left);
		postOderDisplay(node.right);
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

	public void levelDisplay() {
		if (root == null) {
			return;
		}
		Queue<Node> que = new LinkedList<>();
		que.add(root);

		while (!que.isEmpty()) {

			Node check = que.remove();
			System.out.print(check.data + ",");
			if (check.left != null) {
				que.add(check.left);
			}

			if (check.right != null) {
				que.add(check.right);
			}
		}
	}

	public void levelReverseDisplay() {
		if (root == null) {
			return;
		}
		Queue<Node> que = new LinkedList<>();
		Stack<Node> stack = new Stack<>();
		que.add(root);

		while (!que.isEmpty()) {

			Node check = que.remove();
			stack.add(check);
			System.out.print(check.data + ",");
			if (check.left != null) {
				que.add(check.left);
			}

			if (check.right != null) {
				que.add(check.right);
			}
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	// pre_post_In_Oder_Display_Iterrative_Using_Stack_And_Queue.

	private class TraversalPair { // Time_Complexity_is_same_as_in_Recursion.
		private Node node;
		private boolean selfdone;
		private boolean leftdone;
		private boolean rightdone;
	}

	public void preDisplayIrr() {

		TraversalPair pair = new TraversalPair();
		Stack<TraversalPair> stack = new Stack<>();
		pair.node = root;
		stack.add(pair);
		while (!stack.isEmpty()) {
			TraversalPair tp = stack.peek();
			if (tp.selfdone == false) {
				System.out.print(tp.node.data + ",");
				tp.selfdone = true;
			} else if (tp.leftdone == false) {
				if (tp.node.left != null) {
					TraversalPair ld = new TraversalPair();
					ld.node = tp.node.left;
					stack.add(ld);
				}
				tp.leftdone = true;

			} else if (tp.rightdone == false) {
				if (tp.node.right != null) {
					TraversalPair rd = new TraversalPair();
					rd.node = tp.node.right;
					stack.add(rd);

				}
				tp.rightdone = true;
			} else {
				stack.pop();
			}

		}
		System.out.println();

	}

	public void preDisplayIrr2() { // Better_Use_Less_space.
		Stack<Node> stack = new Stack<Node>();
		stack.add(root);
		while (!stack.isEmpty()) {
			Node process = stack.pop();
			System.out.print(process.data + " ");

			if (process.right != null) {
				stack.add(process.left);
			}

			if (process.left != null) {
				stack.add(process.right);
			}

		}
	}

	public void postDisplayIrr() {
		TraversalPair pair = new TraversalPair();
		Stack<TraversalPair> stack = new Stack<>();
		pair.node = root;
		stack.add(pair);
		while (!stack.isEmpty()) {
			TraversalPair tp = stack.peek();
			if (tp.leftdone == false) {
				if (tp.node.left != null) {
					TraversalPair ld = new TraversalPair();
					ld.node = tp.node.left;
					stack.add(ld);
				}
				tp.leftdone = true;

			} else if (tp.rightdone == false) {
				if (tp.node.right != null) {
					TraversalPair rd = new TraversalPair();
					rd.node = tp.node.right;
					stack.add(rd);
				}
				tp.rightdone = true;

			} else if (tp.selfdone == false) {
				System.out.print(tp.node.data + ",");
				tp.selfdone = true;

			} else {
				stack.pop();
			}

		}
		System.out.println();
	}

	public static void postDisplayBtrItr() {

		Stack<Node> st1 = new Stack<Node>();
		Stack<Node> st2 = new Stack<Node>();
		while (!st1.isEmpty()) {
			Node oper = st1.pop();
			st2.add(oper);
			if (oper.left != null) {
				st1.add(oper.left);
			}

			if (oper.right != null) {
				st1.add(oper.right);
			}
		}

		while (!st2.isEmpty()) {
			System.out.print(st2.pop().data + " ");
		}
	}

	public void inOderDisplayIrr() {
		Stack<TraversalPair> stack = new Stack<>();
		TraversalPair pair = new TraversalPair();
		pair.node = root;
		stack.add(pair);
		while (!stack.isEmpty()) {
			TraversalPair tp = stack.peek();
			if (tp.leftdone == false) {
				if (tp.node.left != null) {
					TraversalPair ld = new TraversalPair();
					ld.node = tp.node.left;
					stack.add(ld);
				}
				tp.leftdone = true;

			} else if (tp.selfdone == false) {
				System.out.print(tp.node.data + ",");
				tp.selfdone = true;

			} else if (tp.rightdone == false) {
				if (tp.node.right != null) {
					TraversalPair rd = new TraversalPair();
					rd.node = tp.node.right;
					stack.add(rd);
				}
				tp.rightdone = true;

			} else {
				stack.pop();
			}

		}
		System.out.println();

	}

	public void inOderDispalyIrr2() { // Better_Use_Less_space.
		if (root == null) {
			return;
		}

		Stack<Node> stack = new Stack<Node>();
		stack.add(root);
		Node temp = root;
		while (temp != null) {
			stack.add(temp);
			temp = temp.left;
		}

		while (!stack.isEmpty()) {
			temp = stack.pop();
			System.out.print(temp.data + " ");

			if (temp.right != null) { // Now_i_adjust_the_temp_at_right_it_will_added_by_next_while_loop.
				temp = temp.right;
			}

			while (temp != null) {
				stack.add(temp);
				temp = temp.left;
			}
		}

	}

	// IsBst_and_IsBalanced.

	private class IsBst {
		private boolean isbst;
		private int max;
		private int min;
	}

	public boolean IsBst() {
		return IsBst(root).isbst;
	}

	private IsBst IsBst(Node node) {

		if (node == null) {
			IsBst ib = new IsBst();
			ib.max = Integer.MIN_VALUE;
			ib.min = Integer.MAX_VALUE;
			ib.isbst = true;
			return ib;
		}

		IsBst lbib = IsBst(node.left);// Left_Branch_Is_Bst.
		IsBst rbib = IsBst(node.right);// Right_Branch_Is_Bst.

		IsBst mr = new IsBst();

		if (lbib.isbst && rbib.isbst && node.data > lbib.max && rbib.min > node.data) {
			mr.isbst = true;
		} else {
			mr.isbst = false;
		}

		mr.max = Math.max(Math.max(lbib.max, rbib.max), node.data);
		mr.min = Math.min(Math.min(lbib.min, rbib.min), node.data);

		return mr;
	}

	public boolean isbalanced0() {
		return isbalanced0(root);
	}

	private boolean isbalanced0(Node node) {
		if (node == null) {
			return true;
		}

		int lh = height(node.left);
		int rh = height(node.right);

		if (Math.abs(lh - rh) <= 1 && isbalanced0(node.left) && isbalanced0(node.right)) {
			return true;
		} else {
			return false;
		}

	}

	public class IsBalanced {
		private boolean isbal;
		private int height;
	}

	public boolean IsBalanced() {
		return IsBalanced(root).isbal;
	}

	private IsBalanced IsBalanced(Node node) {
		if (node == null) {
			IsBalanced rr = new IsBalanced();// return_result.
			rr.height = -1;
			rr.isbal = true;
			return rr;
		}

		IsBalanced lbib = IsBalanced(node.left);// left_Branch_IsBalanced.
		IsBalanced rbib = IsBalanced(node.right);// right_Branch_IsBalanced.

		IsBalanced mr = new IsBalanced();
		mr.height = Math.max(lbib.height, rbib.height) + 1;

		int gap = Math.abs(lbib.height - rbib.height);

		if (lbib.isbal && rbib.isbal && gap <= 1) {
			mr.isbal = true;
		} else {
			mr.isbal = false;
		}

		return mr;
	}

	// Construction_through_array.

	public BinaryTree(int[] pre, int[] in, boolean ispre) { // Constructor

		if (ispre) {
			root = constructpre(pre, in, 0, pre.length - 1, 0, in.length - 1);
		} else {
			root = constructpos(pre, in, 0, pre.length - 1, 0, in.length - 1);
		}
	}

	private Node constructpos(int[] pos, int[] in, int psi, int pei, int isi, int iei) {
		if (psi > pei || isi > iei) {
			return null;
		}

		Node node = new Node();
		node.data = pos[pei];
		this.size++;

		int idx = -1;
		for (int i = isi; i <= iei; i++) {
			if (in[i] == node.data) {
				idx = i;
				break;
			}
		}

		int nelonls = idx - isi;// Number_Of_eleement_in_left_side.

		node.left = constructpos(pos, in, psi, nelonls - 1, isi, idx - 1);
		node.right = constructpos(pos, in, nelonls + psi, pei - 1, idx, iei);

		return node;
	}

	private Node constructpre(int[] pre, int[] in, int psi, int pei, int isi, int iei) { // preStartIndex,inStatrIndex.
		if (psi > pei || isi > iei) {
			return null;
		}

		Node node = new Node();
		node.data = pre[psi];
		this.size++;

		int idx = -1;
		for (int i = isi; i <= iei; i++) {
			if (in[i] == node.data) {
				idx = i;
				break;
			}
		}

		int nelonls = idx - isi;// Number_Of_eleement_in_left_side.

		node.left = constructpre(pre, in, psi + 1, nelonls + psi, isi, idx - 1);
		node.right = constructpre(pre, in, nelonls + psi + 1, pei, idx, iei);

		return node;
	}

}
