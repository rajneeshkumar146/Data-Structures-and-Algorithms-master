package Recursion;

import java.util.HashSet;

public class amazon_nozama {

	public static void main(String[] args) {

		String str = "my name is akhil$";

		System.out.println(code(str));
	}

	private static String code(String str) {

		if (str.charAt(0) == '$') {
			return "$";
		}

		String[] words = str.split(" ");

		String last = words[words.length - 1];

		words[words.length - 1] = last.substring(0, last.length() - 1);

		HashSet<String> set = new HashSet<String>();

		for (int i = 0; i < words.length; i++) {

			set.add(words[i]);
		}

		for (int i = 0; i < words.length; i++) {

			if (set.contains(reverse(words[i]))) {
				return words[i];
			}

		}
		return "$";

	}

	private static String reverse(String str) {

		String ans = "";

		for (int i = str.length() - 1; i >= 0; i--) {
			ans = ans + str.charAt(i);
		}
		return ans;
	}

}
