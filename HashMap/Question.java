package HashMap_HashSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Question {

	public static void main(String[] args) {
		int[] one = { 1, 1, 2, 2, 2, 3, 5 };
		int[] two = { 1, 3, 1, 2, 2, 4, 5 };

		int[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };

		System.out.println(gccWR(one, two));
		System.out.println(gccR(one, two));
		System.out.println(longestseq(arr));

	}

	public static Character highestFreqChar(String word) {
		HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
		for (int i = 0; i < word.length(); i++) {
			Character ch = word.charAt(i);
			if (freq.containsKey(ch)) {
				freq.put(ch, freq.get(ch) + 1);
			} else {
				freq.put(ch, 1);
			}
		}

		ArrayList<Character> keys = new ArrayList<Character>(freq.keySet());
		Character rc = ' '; // return Character.
		int maxsf = Integer.MAX_VALUE;
		for (Character key : keys) {
			int temp = freq.get(key);
			if (temp < maxsf) {
				maxsf = temp;
				rc = key;
			}
		}
		return rc;
	}

	public static ArrayList<Integer> gccWR(int[] one, int[] two) { // get_Common_Character_repetation_Not_Allow.
		ArrayList<Integer> ans = new ArrayList<Integer>();
		HashSet<Integer> map = new HashSet<Integer>();
		for (int i : one) {
			if (!map.contains(i)) {
				map.add(i);
			}
		}

		for (int i : two) {
			if (map.contains(i)) {
				ans.add(i);
				map.remove(i);
			}
		}
		return ans;
	}

	public static ArrayList<Integer> gccR(int[] one, int[] two) { // get_Common_Character_repetation_allow.
		ArrayList<Integer> ans = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i : one) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}

		for (int i : two) {
			if (map.containsKey(i)) {
				int temp = map.get(i);
				if (temp > 0) {
					ans.add(i);
					map.put(i, temp - 1);
				} else {
					map.remove(i);
				}
			}
		}
		return ans;
	}

	public static ArrayList<Integer> longestseq(int[] arr) {
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for (int i : arr) {
			map.put(i, false);
		}

		for (int i : arr) {
			if (!map.containsKey(i - 1)) {
				map.put(i, true);
			}
		}
		int maxseq = 0;
		int maxStSeq = 0;
		for (int i : arr) {
			if (map.get(i) == true) {
				int count = 0;
				for (int j = i; map.containsKey(j); j++) {
					count++;
				}
				if (count > maxseq) {
					maxseq = count;
					maxStSeq = i;
				}
			}
		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < maxseq; i++) {
			ans.add(maxStSeq + i);
		}

		return ans;
	}
}
