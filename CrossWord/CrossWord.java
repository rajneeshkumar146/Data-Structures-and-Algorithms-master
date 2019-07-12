package CrossWord;

import java.util.Scanner;

public class CrossWord {

	public static void cross(char[][] box, String[] words, int widx) {
		if (widx == words.length) {
			for (int i = 0; i < box.length; i++) {
				for (int j = 0; j < box.length; j++) {
					System.out.print(box[i][j]);
				}
				System.out.println();
			}
			return;
		}

		String word = words[widx];
		for (int j = 0; j < box.length; j++) {
			for (int i = 0; i < box.length; i++) {
				if (box[i][j] == '-' || box[i][j] == word.charAt(0)) {
					if (canplacethewordshorizonatlly(box, word, i, j)) {
						boolean[] reset = placethewordshorizonatlly(box, word, i, j);
						cross(box, words, widx + 1);
						unplacethewordshorizonatlly(box, word, i, j, reset);
					}

					if (canplacethewordsvertically(box, word, i, j)) {
						boolean[] reset = placethewordsvertically(box, word, i, j);
						cross(box, words, widx + 1);
						unplacethewordsvertically(box, word, i, j, reset);
					}
				}
			}
		}
	}

	private static boolean canplacethewordsvertically(char[][] box, String words, int r, int c) {

		for (int i = 0; i < words.length(); i++) {
			if (r + i >= box[0].length) {
				return false;
			} else if (box[r + i][c] != '-' && box[r + i][c] != words.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	private static boolean[] placethewordsvertically(char[][] box, String words, int r, int c) {
		boolean[] reset = new boolean[words.length()];

		for (int i = 0; i < words.length(); i++) {
			if (box[r + i][c] == '-') {
				box[r + i][c] = words.charAt(i);
				reset[i] = true;
			}
		}

		return reset;
	}

	private static void unplacethewordsvertically(char[][] box, String words, int r, int c, boolean[] reset) {
		for (int i = 0; i < reset.length; i++) {
			if (reset[i] == true) {
				box[r + i][c] = '-';
			}
		}
	}

	private static boolean canplacethewordshorizonatlly(char[][] box, String words, int r, int c) {
		for (int i = 0; i < words.length(); i++) {
			if (c + i >= box[0].length) {
				return false;
			} else if (box[r][c + i] != '-' && box[r][c + i] != words.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	private static boolean[] placethewordshorizonatlly(char[][] box, String words, int r, int c) {
		boolean[] reset = new boolean[words.length()];

		for (int i = 0; i < words.length(); i++) {
			if (box[r][c + i] == '-') {
				box[r][c + i] = words.charAt(i);
				reset[i] = true;
			}
		}

		return reset;
	}

	private static void unplacethewordshorizonatlly(char[][] box, String words, int r, int c, boolean[] reset) {
		for (int i = 0; i < reset.length; i++) {
			if (reset[i] == true) {
				box[r][c + i] = '-';
			}
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		char[][] box = new char[10][0];
		for (int i = 0; i < 10; i++) {
			box[i] = scn.nextLine().toCharArray();
		}
		String[] words = scn.nextLine().split(";");

		System.out.println();
		cross(box, words, 0);

		scn.close();
	}

}
