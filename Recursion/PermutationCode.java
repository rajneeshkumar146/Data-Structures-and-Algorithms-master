package Recursion;

public class PermutationCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a = "abc";

		permutation(a, 0, a.length());
	}

	public static void permutation(String str, int s, int e) {

		if (s == e) {

			System.out.println(str);

		} else {

			for (int i = s; i < e; i++) {
				str = swapper(str, s, i);
				permutation(str, s + 1, e);

			}
		}
	}

	public static String swapper(String str, int i, int j) {

		char[] a = str.toCharArray();

		char temp = a[i];

		a[i] = a[j];

		a[j] = temp;

		return String.valueOf(a);

	}

}
