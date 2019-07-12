package Graph;

public class Number_Find_Island {

	public static void main(String[] args) {
		int graph[][] = { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } };

		System.out.println(Island(graph));
	}

	public static int Island(int[][] graph) {

		int islandCtr = 0;

		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {

				if (graph[i][j] == 1) {
					markDone(graph, i, j);
					islandCtr++;

				}

			}
		}
		return islandCtr;
	}

	private static void markDone(int[][] graph, int i, int j) {

		if (i < 0 || j < 0 || i >= graph.length || j >= graph[i].length || graph[i][j] == 0) {
			return;
		}

		graph[i][j] = 0; // Marked , Visited can be used

		markDone(graph, i + 1, j);

		markDone(graph, i - 1, j);

		markDone(graph, i, j + 1);

		markDone(graph, i, j - 1);

	}

}
