package Recursion;

public class Print_Permutation {

	public static void func(String q, String a) {

		if (q.length() == 0) {
			System.out.println(a);
			return;
		}

		char ch = q.charAt(0);
		String ros = q.substring(1);

		for (int i = 0; i <= a.length(); i++) {

			String l = a.substring(0, i);

			String r = a.substring(i);

			func(ros, l + ch + r);

		}

	}
//
	public static void Print_Permutation_String(String q, String ans) {

		if (q.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = q.charAt(0);
		String ros = q.substring(1);

		for (int i = 0; i <= ans.length(); i++) {

			String l = ans.substring(0, i);

			String r = ans.substring(i);

			Print_Permutation_String(ros, l + ch + r);
		}

	}

	public static void Print_Permutation_StringBuilder(StringBuilder q, StringBuilder ans) {

		if (q.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = q.charAt(0);
		q.deleteCharAt(0);
		for (int i = 0; i <= ans.length(); i++) {
			ans.insert(i, ch);
			Print_Permutation_StringBuilder(q, ans);
			ans.deleteCharAt(i);
		}
		q.insert(0, ch);
	}

	public static void Print_Permutation_2(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String rstr = ques.substring(0, i) + ques.substring(i + 1, ques.length());
			Print_Permutation_2(rstr, ans + ch);
		}
	}

	public static void Print_Permutation_2_Builder(StringBuilder ques, StringBuilder ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			ques.deleteCharAt(i);

			ans.append(ch);
			Print_Permutation_2_Builder(ques, ans);

			ans.deleteCharAt(ans.length());

			ques.insert(i, ch);
		}

	}

	public static void main(String[] args) {

		StringBuilder str = new StringBuilder("abc");
		StringBuilder str2 = new StringBuilder("");

		Print_Permutation_String("ABC", "");

		// Print_Permutation_StringBuilder(str, str2);

		// Print_Permutation_2("abc", "");

		// Print_Permutation_2_Builder(str, str2);

	}

}
