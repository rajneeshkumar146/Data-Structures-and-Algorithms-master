package Recursion;

public class Spiral_Triversal_Matrix {

	public static void main(String[] agrs) {

		int arr[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };

		func(arr);

	}

	private static void func(int[][] arr) {

		int rs = 0;
		int re = arr.length;

		int cs = 0;
		int ce = arr[0].length;
		int i = 0;

		while (rs < re && cs < ce) {
			for (i = cs; i < ce; i++) {
				System.out.print(arr[rs][i] + " ");
			}
			rs++;

			for (i = rs; i < re; i++) {
				System.out.print(arr[i][cs] + " ");
			}
			cs++;

			if (rs < re) {
				for (i = ce - 1; i >= cs; i--) {
					System.out.print(arr[re - 1][i] + " ");
				}
				ce--;
			}

			if (cs < ce) {
				for (i = re - 1; i >= rs; i--) {
					System.out.print(arr[i][cs] + " ");
				}
				re--;
			}
		}
	}

}
