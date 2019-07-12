package Recursion;

public class floodFil_String {

	public static int solve(int A, int B, int C, int D, String[] E) {

		int maze[][] = strtomat(E);

		return func(A, B, C, D, maze);
	}

	static int min = Integer.MAX_VALUE;

	public static int func(int A, int B, int C, int D, int[][] maze) {
		{
			int[][] visited = new int[maze.length][maze[0].length];

			help(A, B, C, D, maze, visited, 0);

			if (min == 0) {
				return -1;
			}

			return min;

		}
	}

	public static void help(int sr, int sc, int dr, int dc, int[][] maze, int[][] visited, int ctr) {

		if (sr == dr && sc == dc) {

			min = Math.min(ctr, min);

			return;
		}

		if (check(maze, visited, sr, sc)) {
			return;
		}

		visited[sr][sc] = 1;

		help(sr + 1, sc, dr, dc, maze, visited, ctr + 1);

		help(sr, sc + 1, dr, dc, maze, visited, ctr + 1);

		visited[sr][sc] = 0;

	}

	private static boolean check(int[][] maze, int[][] visited, int sr, int sc) {

		if (sc < 0 || sc >= maze[0].length || sr < 0 || sr >= maze.length) {

			return true;

		} else {

			return false;

		}

	}

	public static int[][] strtomat(String[] E) {

		int[][] mat = new int[E.length][E[1].length()];

		for (int i = 0; i < E.length; i++) {
			String str = E[i];
			for (int j = 0; j < str.length(); j++) {
				mat[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}

		return mat;

	}

	public static void main(String[] args) {

		String[] str = new String[3];
		str[0] = "00011";
		str[1] = "11000";
		str[2] = "01000";

		solve(1, 1, 4, 5, str);
	}

}
