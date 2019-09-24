package Tree.BST;

public class Client {

	public static void main(String[] args) {

		int[] pre = { 50, 30, 20, 40, 70, 60, 80 };
		int[] in = { 20, 30, 40, 50, 60, 70, 80 };

		BST bst = new BST(pre, in);
		bst.display();
		bst.replaceWithSumOfLarerNode();
		bst.display();
		// bst.preOderDisplay();
		// System.out.println();
		//
		// bst.postOderDisplay();
		// System.out.println();
		//
		// bst.inOderDisplay();
		// System.out.println();
		//
		// bst.levelOrderDisplay();
		// System.out.println();
		//
		// System.out.println(bst.max());
		// System.out.println(bst.min());
		// System.out.println(bst.height());
		//
		// bst.preOderDisplayIre();
		// System.out.println();
		//
		// bst.postOderDisplayIre();
		// System.out.println();
		//
		// bst.inOderDisplayIre();
		// System.out.println();
		//
		// System.out.println();
		// bst.add(78);
		// bst.add(90);
		// bst.display();

	}

}
