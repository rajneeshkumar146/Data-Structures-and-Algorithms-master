package Recursion;

import java.util.ArrayList;

public class BoardPath_AL {

	public static void main(String[] args) {

		System.out.println(getBPaths(0, 1990));

	}

	public static ArrayList<String> getBPaths(int src, int dest) {

		if (src == dest) {

			ArrayList<String> bres = new ArrayList<>();

			bres.add("");

			return bres;

		}
		ArrayList<String> res = new ArrayList<>();

		for (int i = 1; (i <= 6) && (i + src <= dest); i++) {
			int x = src + i;

			ArrayList<String> ans = getBPaths(x, dest);

			for (String var : ans) {
				String path = var + i;

				res.add(path);
			}

		}
		return res;

	}
}
