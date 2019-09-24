package Tree.GenericTree;

public class GenericTreeClent {

	public static void main(String[] args) {
		// 10 3 20 2 50 0 60 0 30 3 70 1 110 0 80 0 90 0 40 2 100 0 120 0
		GenericTree gt = new GenericTree();
		gt.display();
		// System.out.println(gt.hight());
		// gt.LevelOderDisplay();
		// gt.LevelOderLinerwiseDisplay();
		// gt.mirrorImage();
		// gt.display();
		// gt.linearize();
		// gt.display();
		// gt.flatten();
		// gt.display();
		// gt.linearizebtr();
		// gt.display();
		// gt.flatternBtr();
		// gt.display();
		// System.out.println(gt.KthSmallest(3));
		// System.out.println(gt.KthSmallestBtr(3));
		System.out.println();
		gt.kaway(30, 2);
	}

}
