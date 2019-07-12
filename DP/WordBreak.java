package DP;

import java.util.HashSet;
import java.util.List;

public class WordBreak {

	static HashSet<String> dict = new HashSet<String>();

	public static void main(String[] args) {

		String temp_dictionary[] = { "mobile", "samsung", "sam", "sung", "man", "mango", "icecream", "and", "go", "i",
				"like", "ice", "cream" };

		for (String str : temp_dictionary) {
			dict.add(str);
		}

		System.out.println(wordBreakDP("ilikesamsung"));
		System.out.println(wordBreakDP("iiiiiiii"));
		System.out.println(wordBreakDP(""));
		System.out.println(wordBreakDP("ilikelikeimangoiii"));
		System.out.println(wordBreakDP("samsungandmango"));
		System.out.println(wordBreakDP("samsungandmangok"));

	}

	public static boolean wordBreak(String str) {

		if (str.length() == 0) {
			return true;
		}

		for (int i = 1; i <= str.length(); i++) {

			if (dict.contains(str.substring(0, i)) && wordBreak(str.substring(i, str.length()))) {
				return true;
			}

		}
		return false;

	}

	public static boolean wordBreakDP(String s) {

		boolean[] f = new boolean[s.length() + 1];

		f[0] = true;

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (f[j] && dict.contains(s.substring(j, i))) {
					f[i] = true;
					break;
				}
			}
		}

		return f[s.length()];
	}
}
