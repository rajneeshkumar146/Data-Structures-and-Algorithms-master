package Graph;

import java.util.LinkedList;

// Fire house and rotten Orange is same question BFS of Graph approch

public class RottenOrange_FireHouse {
	static class Node {
		int i;
		int j;
		int timestamp;

		Node(int i, int j, int timestamp) {
			this.i = i;
			this.j = j;
			this.timestamp = timestamp;

		}
	}

	static int rotten = 0;

	static int fresh = 0;

	static int oldrotten = 0;

	public static void fun(int[][] arr) {

		LinkedList<Node> queue = new LinkedList<>();

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {

				if (arr[i][j] == 1) {
					fresh++;
				} else if (arr[i][j] == 2) {
					queue.addLast(new Node(i, j, 0));
					oldrotten++;
				}

			}
		}

		rotorange(arr, queue);

	}

	private static void rotorange(int[][] arr, LinkedList<Node> queue) {

		int ts = 0;
		while (!queue.isEmpty()) {
			Node temp = queue.removeFirst();

			ts = temp.timestamp;

			int i = temp.i;
			int j = temp.j;

			if (isValid(i - 1, j, arr)) {
				if (arr[i - 1][j] == 1) {
					arr[i - 1][j] = 2;
					queue.addLast(new Node(i - 1, j, ts + 1));
					rotten++;
				}

			}

			if (isValid(i, j + 1, arr)) {
				if (arr[i][j + 1] == 1) {
					arr[i][j + 1] = 2;
					Node node = new Node(i, j + 1, ts + 1);
					queue.addLast(node);
					rotten++;

				}
			}

			if (isValid(i + 1, j, arr)) {
				if (arr[i + 1][j] == 1) {
					arr[i + 1][j] = 2;
					Node node = new Node(i + 1, j, ts + 1);
					queue.addLast(node);
					rotten++;
				}
			}

			if (isValid(i, j + 1, arr)) {
				if (arr[i][j + 1] == 1) {
					arr[i][j + 1] = 2;
					Node node = new Node(i, j + 1, ts + 1);
					queue.addLast(node);
					rotten++;
				}
			}
		}

		System.out.println(rotten + " + " + oldrotten + " = " + fresh);
		System.out.println(ts);

	}

	private static boolean isValid(int i, int j, int[][] arr) {

		if (i > 0 && i < arr.length && j > 0 && j < arr[0].length)
			return true;

		return false;
	}

	public static void main(String[] args) {
		int[][] arr = { { 0, 1, 0, 0, 0, 1, 0 }, { 1, 1, 1, 0, 0, 1, 1 }, { 0, 2, 0, 0, 0, 1, 0 },
				{ 0, 0, 0, 1, 1, 1, 0 }, { 0, 1, 0, 2, 1, 0, 0 }, { 2, 1, 0, 0, 1, 1, 0 }, { 0, 1, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 0 }, };

		int mat[][] = { { 2, 1, 0, 2, 1 }, { 1, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 } };

		fun(arr);
	}
}
