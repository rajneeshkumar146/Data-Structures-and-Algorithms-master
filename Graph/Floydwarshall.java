package Graph;

public class Floydwarshall {

	public static void main(String[] args) {

		Integer[][] graph = new Integer[6][6];

		graph[0][1] = 2;
		graph[0][2] = 7;
		graph[1][2] = 4;
		graph[1][4] = 7;
		graph[2][3] = 1;
		graph[2][4] = 5;
		graph[3][5] = 6;
		graph[4][5] = 2;

		Integer[][] res = FloydWarshall(graph);

		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res.length; j++) {
				if (res[i][j] == null) {
					System.out.print(" " + "-" + " ");
				} else {
					System.out.print(" " + res[i][j] + " ");
				}

			}
			System.out.println();
		}

	}

	public static Integer[][] FloydWarshall(Integer[][] graph) {

		Integer[][] res = new Integer[graph.length][graph.length];

		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				res[i][j] = graph[i][j];
			}
		}

		for (int i = 0; i < res.length; i++) {
			for (int s = 0; s < res.length; s++) {
				for (int d = 0; d < res.length; d++) {
					if (s == i || i == d) {
						continue;
					} else if (res[s][i] == null || res[i][d] == null) {
						continue;
					} else if (res[s][d] == null) {
						res[s][d] = res[s][i] + res[i][d];
					} else {
						res[s][d] = Math.min(res[s][d], res[s][i] + res[i][d]);
					}
				}

			}
		}

		return res;
	}

}
