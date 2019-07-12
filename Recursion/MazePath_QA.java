package Recursion;

import java.util.ArrayList;

public class MazePath_QA {

	public static void mazepath(int sr, int sc, int dr, int dc, String ans) {

		if (sc == dc && sr == dr) {
			System.out.println(ans);
			return;
		}

		if (sc <= dc) {
			mazepath(sr, sc + 1, dr, dc, ans + "H");
		}

		if (sr <= dr) {

			mazepath(sr + 1, sc, dr, dc, ans + "V");
		}
	}

	public static void main(String[] args) {
		mazepath(0, 0, 3, 3, "");
	}

}
