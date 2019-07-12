package Recursion;

import java.util.ArrayList;

public class AllSubSeqence_AL {

	public static ArrayList<String> gss(String str) {

		if (str.length() == 0) {

			ArrayList<String> bstr = new ArrayList<>();

			bstr.add(" ");

			return bstr;

		}

		char a = str.charAt(0);

		String rst = str.substring(1);

		ArrayList<String> rr = gss(rst);

		ArrayList<String> my = new ArrayList<>();

		for (String ans : rr) {

			my.add(ans);

			my.add(a + ans);

		}

		return my;

	}

	public static void main(String[] args) {

		String str = "abc";

		System.out.println(gss(str));

		ArrayList<String> find = gss(str);

		System.out.println(find);

		System.out.println(find.size());
	}

}
