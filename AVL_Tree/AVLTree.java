package Tree.AVLTree;

public class AVLTree {
	private class Node {
		private Node left;
		private Node right;
		private int data;
		private int height;
	}

	private Node root;
	private int size;

	// AVLTool----------------------------------------------------------------------------------------------------------------------------------

	public void insert(int data) {
		root = insert(data, root);

	}

	private Node insert(int data, Node node) {
		if (node == null) { // for_root
			node = new Node();
			node.data = data;
			this.size++;

		} else if (data < node.data) { // Left_Portion.

			node.left = insert(data, node.left);
			if (getBalanceFactor(node) > 1) {
				if (data < node.left.data) { // LLRotation
					node = LeftRotationLL(node);

				} else { // LRRotation
					node.left = RightRotationRR(node.left);
					node = LeftRotationLL(node);

				}
			}

		} else if (data > node.data) { // Right_Portion.

			node.right = insert(data, node.right);
			if (getBalanceFactor(node) < -1) {
				if (data > node.right.data) { // RRRotation.
					node = RightRotationRR(node);
				} else { // RLRotation.
					node.right = LeftRotationLL(node.right);
					node = RightRotationRR(node);
				}
			}

		} else {
			// Duplicate_data.Do_Nothing.
		}

		updateHeight(node);

		return node;
	}

	public void delete(int data) {
		root = delete(root, data);
	}

	private Node delete(Node node, int data) {
		if (node == null) {
			return null;
		}

		if (data < node.data) {
			node.left = delete(node.left, data);
		} else if (data > node.data) {
			node.right = delete(node.right, data);
		} else {
			if (node.left == null) {
				this.size--;
				node = node.right;
			} else if (node.right == null) {
				this.size--;
				node = node.left;
			} else {
				node.data = max(node.left);
				node.left = delete(node.left, node.data);
			}
		}

		// if there was only one node in the tree which got deleted above return
		// null
		if (node == null) {
			return null;
		}

		// update the height of the node
		updateHeight(node);

		if (getBalanceFactor(node) > 1) {

			if (getBalanceFactor(node.left) >= 0) { // LL._if_it_is_leaf_then_equal_to_is_must.
				node = LeftRotationLL(node);
			} else { // LR.
				node.left = LeftRotationLL(node.left);
				node = RightRotationRR(node);
			}
		} else if (getBalanceFactor(node) < -1) {

			if (getBalanceFactor(node.right) <= 0) { // RR._if_it_is_leaf_then_equal_to_is_must.
				node = RightRotationRR(node);
			} else { // RL.
				node.right = RightRotationRR(node.right);
				node = LeftRotationLL(node);
			}
		}
		return node;
	}

	private int getBalanceFactor(Node node) {
		if (node == null) {
			return 0;
		}
		return height(node.left) - height(node.right);
	}

	private Node LeftRotationLL(Node A) {
		Node B = A.left;
		Node Bright = B.right;

		// Rotation.
		B.right = A;
		A.left = Bright;

		// UpdateHeight.
		updateHeight(A);
		updateHeight(B);

		return B;

	}

	private Node RightRotationRR(Node A) {
		Node B = A.right;
		Node Bleft = B.left;

		// Roation.
		B.left = A;
		A.right = Bleft;

		// UpdateHeight.
		updateHeight(A);
		updateHeight(B);
		return B;
	}

	private void updateHeight(Node node) {
		node.height = Math.max(height(node.left), height(node.right)) + 1;
	}

	// General_Funtions.----------------------------------------------------------------------------------------------------------------------

	public int height(Node node) {
		if (node == null) {
			return 0;
		}
		return node.height;
	}

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

		return size2(node.left) + size2(node.right) + 1;
	}

	public boolean isEmpty(Node node) {
		return (this.size == 0);
	}

	public void clear() {
		this.root = null;
	}

	public boolean ContainsKey(int data) {
		return (ContainsKey(root, data) == null ? false : true);
	}

	private Node ContainsKey(Node node, int data) {
		if (node == null) {
			return null;
		}
		if (data == node.data) {
			return node;
		} else if (data < node.data) {
			return ContainsKey(node.left, data);
		} else if (data > node.data) {
			return ContainsKey(node.right, data);
		} else {
			return null;
		}

	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {

		if (node.right != null) {
			return max(node.right);
		} else {
			return node.data;
		}
	}

	public int min() {
		return min(root);
	}

	private int min(Node node) {

		if (node.left != null) {
			return min(node.left);
		} else {
			return node.data;
		}
	}

	// Display_Functions.-----------------------------------------------------------------------------------------------------------------------

	public void display() {
		display(this.root);
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

	public void preOder() {
		preOder(this.root);
	}

	private void preOder(Node node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data + " ");
		preOder(node.left);
		preOder(node.right);
	}

	public void postOder() {
		postOder(root);
	}

	private void postOder(Node node) {
		if (node == null) {
			return;
		}

		postOder(node.left);
		System.out.print(node.data + " ");
		postOder(node.right);
	}

	public void inOder() {
		inOder(root);
	}

	private void inOder(Node node) {
		if (node == null) {
			return;
		}

		inOder(node.left);
		System.out.print(node.data + " ");
		inOder(node.right);
	}

}
