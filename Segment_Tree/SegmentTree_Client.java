package Segment_Tree;

public class SegmentTree_Client {

	public static void main(String[] args) {

		int[] arr = { 2, 0, -1, 3, 8, -4, 2, 3 };

		ISegmentOperator operator = new MaxOperator();

		SegmentTree st = new SegmentTree(arr, operator);

		st.display();

		System.out.println();

		System.out.println(st.query(0, 6));

		System.out.println();

		st.update(3, 15);

		System.out.println();

		System.out.println();

		System.out.println(st.query(0, 6));

		System.out.println();

		System.out.println(st.query(0, 6));

	}

}
