package HashMap;

import java.util.*;

public class HashMap_Words {

	public static void main(String[] args) {

		String word = "asvbajdkahkjhkjljlaaaaaaaaa";

		hfc(word);

	}

	public static void hfc(String word) {

		HashMap<Character, Integer> hmap = new HashMap<>();
		int i = 0;
		while (word.length() > i) {

			char fst = word.charAt(0);

			hmap.put(fst, hmap.get(fst) == null ? 1 : hmap.get(fst) + 1);

			i++;

		}

		ArrayList<Character> map = new ArrayList<>(hmap.keySet());

		int max = Integer.MIN_VALUE;
		char c = ' ';

		for (char ch : map) {
			if (max < hmap.get(ch)) {
				max = hmap.get(ch);
				c = ch;
			}
		}

		System.out.println(max + " " + c);

	}
}
