package Recursion;

public class Nqueen_2D {

	static int ctr = 0;

	public static void nqueensPERMUTATION(boolean[][] board, int q, String asf) {

		if (q == board.length) {

			ctr++;
			System.out.println(ctr + ":- " + asf);

			return;
		}

		for (int i = 1; i <= (board.length * board.length); i++) {

			int br = (i - 1) / board.length;
			int bc = (i - 1) % board[0].length;

			if (board[br][bc] == false) {

				board[br][bc] = true;

				nqueensPERMUTATION(board, q + 1, asf + "q" + q + "c" + i + " ");

				board[br][bc] = false;
			}

		}

	}

	public static void nqueensCOMBINATION(boolean[][] board, int q, String asf, int idx) {

		if (q == board.length) {

			ctr++;
			System.out.println(ctr + ":- " + asf);

			return;
		}

		for (int i = idx; i <= (board.length * board.length); i++) {

			int br = (i - 1) / board.length;
			int bc = (i - 1) % board[0].length;

			if (board[br][bc] == false) {

				board[br][bc] = true;

				nqueensPERMUTATION(board, q + 1, asf + "q" + q + "c" + i + " " + i + 1);

				board[br][bc] = false;
			}

		}

	}

	public static void nqueens(boolean[][] board, int q, String asf, int idx) {

		if (q == board.length) {

			if (isTheBoardSafe(board)) {
				ctr++;
				System.out.println(ctr + ". " + asf);
			}
			return;
		}

		for (int i = idx + 1; i <= board.length * board.length; i++) {
			int ir = (i - 1) / board.length;
			int ic = (i - 1) % board.length;

			if (board[ir][ic] == false) {
				board[ir][ic] = true;
				nqueens(board, q + 1, asf + "q" + q + "c" + i + " ", i);
				board[ir][ic] = false;
			}
		}

	}

	private static boolean isTheBoardSafe(boolean[][] board) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == true) {
					if (isTheQueenSafe(board, i, j) == false) {
						return false;
					}
				}
			}
		}

		return true;
	}

	private static boolean isTheQueenSafe(boolean[][] board, int r, int c) {

		int[][] dirs = { { -1, 0 }, // north
				{ -1, 1 }, // north-east
				{ 0, 1 }, // east
				{ 1, 1 }, // south-east
				{ 1, 0 }, // south
				{ 1, -1 }, // south-west
				{ 0, -1 }, // west
				{ -1, -1 } // north-west
		};

		for (int rad = 1; rad < board.length; rad++) {

			for (int[] dir : dirs) {
				int renemy = r + (dir[0] * rad);
				int cenemy = c + (dir[1] * rad);

				if (renemy >= 0 && renemy < board.length && cenemy >= 0 && cenemy < board[0].length

						&& board[renemy][cenemy] == true) {

					return false;
				}
			}
		}

		return true;

	}

	private static boolean isTheKnkightSafe(boolean[][] board, int r, int c) {

		int i = r;
		int j = c;

		return true;

	}

	public static void main(String[] args) {
		boolean[][] board = new boolean[5][5];

		// nqueensPERMUTATION(board, 0, "");

		System.out.println();

		// nqueensCOMBINATION(board, 0, "", 1);

		nqueens(board, 0, "", 0);

	}
}
