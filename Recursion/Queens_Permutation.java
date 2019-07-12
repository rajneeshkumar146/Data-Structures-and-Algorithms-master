package Recursion;

public class Queens_Permutation {

	public static void queens(boolean[] arr, int n, int q, String asf) {

		if (q == n) {
			System.out.println(asf);
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == false) {
				arr[i] = true;

				queens(arr, n, q + 1, asf + "Q" + q + "B" + i + "  ");

				arr[i] = false;

			}
		}

	}

	public static void queens_space_efficent(int arr, int n, int q, String asf) {

		if (q == n) {
			System.out.println(asf);
			return;
		}

		for (int i = 0; i < n; i++) {
			if ((arr & (1 << i)) == 0) {

				arr ^= (1 << i);

				queens_space_efficent(arr, n, q + 1, asf + "Q" + q + "B" + i + "  ");

				arr ^= (i << i);

			}
		}

	}
  
	public static void main(String[] args) {

		boolean[] arr = new boolean[4];

		queens(arr, 2, 0, "");

		// TODO Auto-generated method stub

	}

}
