package Recursion;

import java.util.ArrayList;

public class NokiaKeypad_QA {

	static String[] codes = { ".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

	public static void getKPC(String str, String ans) {

		if (str.length() == 0) {
			System.out.println(ans);

			return;

		}

		char frst = str.charAt(0);

		String rstr = str.substring(1);

		String a = codes[frst - '0'];

		for (int i = 0; a.length() > i; i++) {

			getKPC(rstr, ans + a.charAt(i));

		}

	}

	public static void main(String[] args) {

		getKPC("339", "");

	}

}
