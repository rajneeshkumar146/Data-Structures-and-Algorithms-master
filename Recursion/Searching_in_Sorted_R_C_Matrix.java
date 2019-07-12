package Recursion;

public class Searching_in_Sorted_R_C_Matrix {

	public static void main(String[] args) {
		int mat[][] = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };

		search(mat, 20);
	}

	private static void search(int[][] mat, int target) {

		if (mat.length == 0 || mat[0].length == 0) {
			return;
		}

		int row_num = mat.length;
		int col_num = mat[0].length;

		int low = 0;
		int high = row_num * col_num - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			int val = mat[mid / col_num][mid % col_num];
			if (val == target) {
				System.out.println(mid / col_num + " , " + mid % col_num);
				return;
			} else if (val < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		System.out.println("Not Found");
		return;
	}

}
