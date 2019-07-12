package HashMap;

import java.util.ArrayList;
import java.util.HashMap;

public class greatest_Common_Char_1_2 {

	public static void main(String[] args) {
		Integer[] arr = { 4, 1, 3, 1, 2, 5, 2 };

		Integer[] arr2 = { 4, 5, 1, 2, 1, 2, 1 };

		for (int x : arr) {
			System.out.print(x + " ");
		}

		System.out.println();

		for (int x : arr2) {
			System.out.print(x + " ");
		}

		System.out.println();

		System.out.println();

		gcc1(arr, arr2);

	}

	public static void gcc1(Integer[] one, Integer[] two) {

		HashMap<Integer, Integer> fmap = new HashMap<>();

		for (int i = 0; i < one.length; i++) {

			if (!fmap.containsKey(one[i])) {

				fmap.put(one[i], one[i]);

			}

		}

		for (int j = 0; j < two.length; j++) {

			if (fmap.containsKey(two[j])) {

				System.out.print(fmap.get(two[j]) + " ");

				fmap.remove(two[j]);
			}
		}

	}

	public static void gcc2(Integer[] one, Integer[] two) {

		HashMap<Integer, Integer> fmap = new HashMap<>();

		for (int i = 0; i < one.length; i++) {

			if (!fmap.containsKey(one[i])) {

				fmap.put(one[i], one[i]);

			}

		}

		System.out.println(fmap);

		for (int j = 0; j < two.length; j++) {

			if (fmap.containsKey(two[j])) {
				System.out.println(fmap.get(two[j]));

				fmap.remove(two[j]);
			}
		}

	}
}
