package Recursion;

public class Searching_in_Matrix {

	public static void main(String[] args) {
		int mat[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };

		search(mat, 29);
	}

	private static void search(int[][] mat, int target) {
		if (mat.length == 0 || mat[0].length == 0) {
			System.out.println("Notfound");
			return;
		}

		int n = mat.length;
		int i = 0;
		int j = mat[0].length - 1;

		while (i < n && j > 0) {

			if (mat[i][j] == target) {
				System.out.println(i + " , " + j);
				return;
			} else if (mat[i][j] < target) {
				i++;
			} else {
				j--;
			}

		}

		System.out.println("Not Found");
		return;
	}

}
