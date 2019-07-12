package Recursion;

public class floodFill {

	public static void floodfill(int[][] maze, int[][] visited, int sr, int sc, String asf) {

		if (sr == maze.length - 1 && sc == maze[0].length - 1) {

			System.out.println(asf);

			return;
		}

		if (check(maze, visited, sr, sc)) {
			return;
		}

		visited[sr][sc] = 1;

		floodfill(maze, visited, sr - 1, sc, asf + "T");

		floodfill(maze, visited, sr, sc + 1, asf + "R");

		floodfill(maze, visited, sr + 1, sc, asf + "D");

		floodfill(maze, visited, sr, sc - 1, asf + "L");

		visited[sr][sc] = 0;

	}

	private static boolean check(int[][] maze, int[][] visited, int sr, int sc) {

		if (sc < 0 || sc >= maze[0].length || sr < 0 || sr >= maze.length) {

			return true;

		} else if (maze[sr][sc] == 1 || visited[sr][sc] == 1) {

			return true;

		} else {

			return false;

		}

	}

	public static void main(String[] args) {

		int[][] maze = { { 0, 1, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 1, 1, 1, 1, 0 }, { 0, 0, 0, 1, 1, 0, 0, 0 },
				{ 0, 1, 0, 0, 0, 0, 1, 1 }, { 0, 1, 0, 1, 1, 0, 1, 1 }, { 0, 1, 0, 0, 0, 0, 0, 0 } };

		int[][] visited = new int[maze.length][maze[0].length];

		floodfill(maze, visited, 0, 0, "");
		// TODO Auto-generated method stub

	}

}
