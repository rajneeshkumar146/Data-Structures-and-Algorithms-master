package Recursion;

import java.util.ArrayList;

public class AllSubSequence_ASCII_AL {

	public static ArrayList<String> gssa(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();

			br.add(" ");

			return br;

		}

		char a = str.charAt(0);
		String rtr = str.substring(1);

		ArrayList<String> rr = gssa(rtr);

		ArrayList<String> mr = new ArrayList<>();

		for (String ans : rr) {

			mr.add(ans);

			mr.add(a + ans);

			mr.add((int) a + ans);

		}

		return mr;

	}

	public static void main(String[] args) {

		String str = "akhil";

		ArrayList<String> ans = gssa(str);

		System.out.println(ans);
		System.out.println(ans.size());
	}
}
