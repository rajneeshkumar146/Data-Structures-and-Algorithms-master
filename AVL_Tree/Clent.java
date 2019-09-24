package Tree.AVLTree;

public class Clent {

	public static void main(String[] args) {
		AVLTree tree = new AVLTree();

		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(6);
		tree.insert(5);
		tree.insert(20);
		tree.insert(25);
		tree.insert(50);
		tree.insert(77);

		tree.display();

	}

}
