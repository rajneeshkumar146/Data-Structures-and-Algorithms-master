package Recursion;

public class Queens_Combination {

	static int ctr = 0;

	public static void queenscombination(boolean[] arr, int tq, int q, String asf, int idx) {

		if (tq == q) {
			ctr++;
			System.out.println(asf + " : -  " + ctr);
			return;
		}

		for (int i = idx; i < arr.length; i++) {
			if (arr[i] == false) {
				arr[i] = true;

				queenscombination(arr, tq, q + 1, asf + "Q" + q + "B" + i + "  ", i + 1);

				arr[i] = false;
			}
		}

	}

	public static void queenscombinationbox(boolean[] arr, int tq, int q, int cb, String asf) {

		if (tq == q) {
			System.out.println(asf);
			return;
		}

		if (cb == arr.length) {
			return;
		}

		queenscombinationbox(arr, tq, q, cb + 1, asf);

		if (arr[cb] = false) {

			arr[cb] = true;

			queenscombinationbox(arr, tq, q, cb + 1, asf);

			arr[cb] = true;
		}
	}

	public static void main(String[] args) {

		boolean[] arr = new boolean[4];

		queenscombination(arr, 2, 0, "", 0);

	
	}

}
