package Recursion;

import java.util.ArrayList;

public class NokiaKeypad_AL {

	static String[] codes = { ".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

	public static ArrayList<String> getKPC(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();

			br.add(" ");

			return br;

		}

		char frst = str.charAt(0);

		String rstr = str.substring(1);

		ArrayList<String> rr = getKPC(rstr);

		ArrayList<String> mm = new ArrayList<>();

		for (String var : rr) {

			String code = codes[frst - '0'];

			for (int i = 0; i < code.length(); i++) {

				char chcode = code.charAt(i);

				mm.add(chcode + var);

			}

		}
		return mm;

	}

	public static ArrayList<String> getKPCprac(String str) {

		if (str.length() == 0) {

			ArrayList<String> bres = new ArrayList<>();

			bres.add("");

			return bres;
		}

		char a = str.charAt(0);

		String rs = str.substring(1);

		ArrayList<String> rr = getKPCprac(rs);

		ArrayList<String> mr = new ArrayList<>();

		for (String var : rr) {
			String code = codes[a - '0'];

			for (int i = 0; i < code.length(); i++) {
				char x = code.charAt(i);

				mr.add(x + var);

			}

		}
		return mr;

	}

	public static void main(String[] args) {

		System.out.println(getKPCprac("367"));

		System.out.println();

	}
}
