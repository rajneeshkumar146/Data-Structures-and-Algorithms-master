package Recursion;

import java.util.Collections;
import java.util.PriorityQueue;

public class Merge_K_Sorted {

	// https://www.youtube.com/watch?v=6bvnZzwiKzs

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = { { 1, 3 }, { 2, 4, 6 }, { 0, 9, 10, 11 } };

		int[] result = Kmerger(arr);

		for (int x : result) {
			System.out.print(x + " ");
		}
	}

	static class QueueNode implements Comparable<QueueNode> {
		int array; // Array location via Row pos
		int idx; // idx of the current element we are s
		int val; // val of the array or

		public QueueNode(int array, int idx, int val) {
			this.array = array;
			this.idx = idx;
			this.val = val;
		}

		public int compareTo(QueueNode o) {
			if (this.val > o.val)
				return -1;

			if (this.val < o.val)
				return 1;

			return 0;
		}

	}

	public static int[] Kmerger(int[][] arr) {

		PriorityQueue<QueueNode> pq = new PriorityQueue<Merge_K_Sorted.QueueNode>(Collections.reverseOrder());

		int size = 0;
		for (int i = 0; i < arr.length; i++) {

			size += arr[i].length;

			if (arr[i].length > 0) {
				pq.add(new QueueNode(i, 0, arr[i][0]));
			}
		}

		int result[] = new int[size];

		for (int i = 0; !pq.isEmpty(); i++) {

			QueueNode node = pq.poll();

			result[i] = node.val;

			int idx = node.idx + 1;

			if (idx < arr[node.array].length) {
				pq.add(new QueueNode(node.array, idx, arr[node.array][idx]));
			}

		}

		return result;
	}

}
