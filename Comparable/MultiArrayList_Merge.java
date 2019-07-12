package Comparable;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MultiArrayList_Merge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		PriorityQueue<Node> min = new PriorityQueue<>();
		
		
		

	}

	public static class Node implements Comparable<Node> {
		int val;
		int listno;
		int datano;

		public Node(int val, int listno, int datano) {

			this.val = val;
			this.listno = listno;
			this.datano = datano;

		}

		@Override
		public int compareTo(Node o) {
			return this.val - o.val;
		}

	}

}
