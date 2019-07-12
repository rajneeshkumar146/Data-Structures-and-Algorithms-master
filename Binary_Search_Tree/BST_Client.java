package Binary_Search_Tree;

public class BST_Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 12, 25, 37, 50, 62, 75, 87 };

		BST bst = new BST(arr);

		bst.display();

		System.out.println();
		System.out.println(bst.min());
		System.out.println();

		System.out.println();
		System.out.println(bst.max());
		System.out.println();

		System.out.println();
		System.out.println(bst.find(62));
		System.out.println();

		System.out.println();
		bst.add(30);
		bst.add(40);
		bst.display();

		System.out.println();
		bst.removeleave(30);
		bst.removeleave(40);
		bst.display();

		System.out.println();
		bst.printInRange(35, 65);
		System.out.println();

		bst.display();
		System.out.println();
		// bst.replacewithsumoflarger();
		bst.display();

		System.out.println();

		bst.levelorder();

		System.out.println();
		System.out.println();

//		bst.levelorder_lineWise();
		System.out.println();

		bst.levelorder_lineWise_NULL();

		System.out.println();
		System.out.println();

		bst.printRightView();

		System.out.println();
		System.out.println();

		bst.printleftView();

		System.out.println();
		System.out.println();

		bst.TargetPair(112);

		System.out.println();

		// bst.FixBST();
	}

}
