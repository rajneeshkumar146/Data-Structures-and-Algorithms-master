package Recursion;

import java.util.PriorityQueue;

public class K_Closest_Points_Origin {

	public static void main(String[] args) {

		int arr[][] = { { 2, 3 }, { 12, 30 }, { 40, 50 }, { 5, 1 }, { 12, 10 }, { 3, 4 } };
		int k = 2;

		printMatrix(func(arr, k));

	}

	private static class pair implements Comparable<pair> {
		int x;
		int y;

		pair(int x, int y) {
			this.x = x;
			this.y = y;

		}

		@Override
		public int compareTo(pair o) {
			return ((o.x) * (o.x) + (o.y) * (o.y)) - ((this.x * this.x) + (this.y * this.y));
		}
	}

	private static int[][] func(int[][] points, int k) {

		PriorityQueue<pair> pq = new PriorityQueue<>();

		for (int i = 0; i < points.length; i++) {
			pq.add(new pair(points[i][0], points[i][1]));

			if (pq.size() > k) {
				pq.remove();
			}
		}

		int[][] ans = new int[k][2];

		for (int i = 0; i < k; i++) {

			pair temp = pq.remove();

			ans[i][0] = temp.x;
			ans[i][1] = temp.y;
		}

		return ans;

	}

	private static void printMatrix(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {

				System.out.print(mat[i][j] + " ");

			}
			System.out.println();
		}
	}
}
