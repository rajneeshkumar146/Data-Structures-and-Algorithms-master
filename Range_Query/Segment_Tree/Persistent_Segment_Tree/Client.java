package Tree.SegmentTree.PersistentSegmentTree;

import java.util.Scanner;

public class Client {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// int[] arr = takeinput();
		int[] arr = { 1, 3, 5, 7, 9, 11, 12 };
		PresistentSegmentTree st = new PresistentSegmentTree(arr);
		st.display(0);
		System.out.println(st.query(0, 5, 6));
		st.update(1, 5, 2);
		System.out.println(st.query(0, 5, 6));
		// System.out.println(st.query(2, 5));
		// st.update(2, -5);
		// System.out.println(st.query(2, 5));
	}

	private static int[] takeinput() {
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}

}
