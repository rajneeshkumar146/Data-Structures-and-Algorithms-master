package Recursion;

public class BoardPath_QA {

	public static void BoardPath_QA(int s, int d, String ans) {

		if (s == d) {
			System.out.println(ans);

			return;
		}

		for (int i = 1; i <= 6 && i + s <= d; i++) {

			int x = s + i;

			BoardPath_QA(x, d, ans + i);

		}

	}

	public static void main(String[] args) {

		BoardPath_QA(0, 6, "");

	}

}
