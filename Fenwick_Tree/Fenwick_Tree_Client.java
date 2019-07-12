package Fenwick_Tree;

public class Fenwick_Tree_Client {

	public static void main(String[] args) {
		int[] arr = { 2, 0, -1, 3, 8, -4, 2, 3 };

		FenwickTree ft = new FenwickTree(arr);

		System.out.println(ft.query(0, 6));

		ft.update(3, 10 - 8);

	}

}
