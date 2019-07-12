package Recursion;

public class MazePath_MULTIMOVE_QA {

	static int ctr = 0;

	public static void MazePath_MULTIMOVE_QA(int sr, int sc, int dr, int dc, String ans) {

		if (sc == dc && sr == dr) {
			System.out.println(ans);

			ctr++;

			return;
		}

		for (int i = 1; i < dr && i + sr <= dr; i++) {

			MazePath_MULTIMOVE_QA(sr + i, sc, dr, dc, ans + "H" + i);

		}

		for (int i = 1; i < dc && i + sc <= dc; i++) {

			MazePath_MULTIMOVE_QA(sr, sc + i, dr, dc, ans + "V" + i);
		}

		for (int i = 1, j = 1; i < dr && j < dc && i + sc <= dc && j + sr <= dr; i++, j++) {

			MazePath_MULTIMOVE_QA(sr + i, sc + i, dr, dc, ans + "D" + (i + j));
		}

	}

	public static void main(String[] args) {
		MazePath_MULTIMOVE_QA(0, 0, 3, 3, "");

		System.out.println(ctr);
	}

}
