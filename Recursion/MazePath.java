package Recursion;

import java.util.ArrayList;

public class MazePath {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		System.out.println(mazepath(0, 0, 9, 9));

		long stop = System.currentTimeMillis();

		System.out.println(stop - start);

	}

	public static ArrayList<String> mazepath(int sr, int sc, int dr, int dc) {

		if (sr == dr && sc == dc) {

			ArrayList<String> bres = new ArrayList<>();
			bres.add("");
			return bres;

		}

		ArrayList<String> myres = new ArrayList<>();

		if (dr > sr) {

			ArrayList<String> res = mazepath(sr + 1, sc, dr, dc);

			for (String var : res) {
				myres.add(var + "H");
			}

		}

		if (dc > sc) {
			ArrayList<String> res2 = mazepath(sr, sc + 1, dr, dc);

			for (String var : res2) {
				myres.add(var + "V");
			}

		}

		return myres;

	}

}
