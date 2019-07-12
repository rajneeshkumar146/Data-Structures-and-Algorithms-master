package KMP;

public class KMP {

	public static void main(String[] args) {
		String s = "asdfgsdfgasdfg";

		String p = "asd";

		patternMatching(s, p);

	}

	private static void patternMatching(String s, String p) {

		int[] lps = preprocessing(p);

		int i = 0;
		int j = 0;

		while (i < s.length()) {

			if (s.charAt(i) == p.charAt(j)) {
				i++;
				j++;

				if (j == p.length()) {
					System.out.println(p + " " + (i - j));
					j = lps[j - 1];
				}
			} else {
				if (j > 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}

		}

	}

	private static int[] preprocessing(String p) {

		int[] lps = new int[p.length()];

		int i = 1;
		int j = 0;

		while (i < p.length()) {
			if (p.charAt(i) == p.charAt(j)) {

				j++;

				lps[i] = j;

				i++;

			} else {
				if (j > 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}

		return lps;

	}

}
