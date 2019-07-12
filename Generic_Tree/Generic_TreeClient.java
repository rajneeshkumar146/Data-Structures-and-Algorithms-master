package Generic_Tree;

public class Generic_TreeClient {

	public static void main(String[] args) {

		int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, 140,
				-1, -1, -1 };
		// TODO Auto-generated method stub

		Generic_Tree gt = new Generic_Tree(arr);

		gt.display();

		System.out.println();

		System.out.println(gt.height());
		System.out.println();

		System.out.println(gt.sizer());
		System.out.println();

		System.out.println(gt.max());

		System.out.println();

		System.out.println(gt.find(50));

		System.out.println();

		System.out.println(gt.nodeToRootPath(110));

		System.out.println();

		System.out.println(gt.LCA(110, 70));

		System.out.println();

		System.out.println(gt.distanceBTWnode(110, 70));

		System.out.println();

		System.out.println(gt.distanceBTWnode_2(110, 70));

		System.out.println();

		gt.display();

		System.out.println();

		gt.mirror();

		gt.display();

		gt.mirror();

		System.out.println();

		gt.display();

		System.out.println();

		// gt.removeLeaves();

		System.out.println();

		gt.display();

		System.out.println();

		gt.preOrder();

		System.out.println();
		System.out.println();

		gt.postOrder();

		System.out.println();
		System.out.println();

		gt.printKthLevel(2);

		System.out.println();
		System.out.println();

		gt.levelOrder();

		System.out.println();
		System.out.println();

		gt.levelOrderLineWise();

		System.out.println();

		gt.spiralLevelOrder_prec();

		System.out.println();

		gt.display();

		System.out.println();

		// gt.linearize();

		gt.linearize_Better();

		System.out.println();

		gt.display();
		System.out.println();

		// gt.isMirrorImage(other);
		// gt.isSymetric(other);
		// gt.isMorphic(other);
	}

}
