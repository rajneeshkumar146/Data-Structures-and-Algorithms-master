package Disjoint_Sets;

import java.util.Collections;
import java.util.PriorityQueue;

public class Job_sequencing {

	public static void main(String[] args) {

		String names = "abcdefghijklmnopqrstuv";

		int[] dline = { 4, 2, 1, 8, 3, 2, 1, 2, 6, 5, 7, 9, 2, 6, 5, 2, 7, 6, 9, 1, 6 };

		int[] profit = { 100, 67, 94, 44, 33, 77, 11, 99, 37, 46, 3447, 78, 44, 39, 75, 49, 33, 48, 92, 43, 90 };

		char[] ch = solve(names, dline, profit);

	}

	public class Pair implements Comparable<Pair> {

		char j;
		int d;
		int p;

		public Pair(char j, int d, int p) {

			this.j = j;
			this.d = d;
			this.p = p;

		}

		@Override
		public int compareTo(Pair o) {
			return this.p - o.p;
		}

	}

	private static char[] solve(String jobs, int[] dlines, int[] profits) {

		int c = 0;
		for (int i = 0; i < dlines.length; i++) {
			if (c > dlines[i]) {
				c = dlines[i];
			}
		}

		char[] str = new char[c];

		boolean[] state = new boolean[c];

		PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < dlines.length; i++) {
//			pq.add(new Pair(jobs.charAt(i), dlines[i], profits[i]));
		}

		int[] space = new int[dlines.length];

		for (int i = 0; i < space.length; i++) {
			space[i] = i;
		}

		while (pq.size() > 0) {

			Pair rem = pq.remove();

			if (state[rem.d] == false) {

				str[rem.d] = rem.j;
				state[rem.d] = true;
				// union();

			} else {

				for (int i = (rem.d - 1); i > 0; i--) {
					if (state[i] == false) {

						str[i] = rem.j;
						state[i] = true;
						// union();
						break;

					}

				}
			}

		}

		return str;

	}

}
