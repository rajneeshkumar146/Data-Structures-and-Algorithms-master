package Recursion;

public class Position_of_Robot {

	public static void main(String[] args) {

		String moves = "UDDLLRUUUDUURUDDUULLDRRRR";

		func(moves, 0, 0);

	}

	private static void func(String moves, int i, int j) {

		if (moves.length() == 0) {
			System.out.print(i + " , " + j);
			return;
		}

		char ch = moves.charAt(0);
		String rstr = moves.substring(1);

		if (ch == 'U') {

			i += 1;

		} else if (ch == 'D') {

			i -= 1;

		} else if (ch == 'L') {

			j -= 1;
		} else if (ch == 'R') {

			j += 1;
		}

		func(rstr, i, j);

	}
}
