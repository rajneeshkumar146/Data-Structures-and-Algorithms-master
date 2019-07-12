package HashMap;

import java.util.HashMap;

public class longest_continous_sequence {

	public static void main(String[] args) {

		Integer[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };

		LCS(arr);

	}

	public static void LCS(Integer[] arr) {

		HashMap<Integer, Boolean> fmap = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			fmap.put(arr[i], true);
		}

		for (int j = 0; j < arr.length; j++) {
			if (fmap.containsKey((arr[j] - 1))) {

				fmap.put(arr[j], false);
			}
		}

		int range = 0;
		int sp = 0;

		for (int val : arr) {

			if (fmap.get(val)) {
				int temp = 1;
				sp = val;
				while (fmap.containsKey(val + temp)) {
					temp++;
				}
				if (temp > range) {
					range = temp;
					sp = val;
				}

			}
		}

		for (int i = 0; i < range; i++) {
			System.out.print(sp + i + " ");
		}
	}

}
