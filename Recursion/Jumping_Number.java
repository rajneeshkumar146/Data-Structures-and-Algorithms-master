package Recursion;

import java.util.LinkedList;

public class Jumping_Number {

	public static void main(String[] args) {

		int n = 40;

		jumpingnumber(n);
	}

	private static void jumpingnumber(int n) {

		System.out.println(0);
		for (int i = 1; i <= n && i <= 9; i++) {
			BFS(n, i);
		}
	}

	public static void BFS(int x, int num) {

		LinkedList<Integer> queue = new LinkedList<Integer>();

		queue.add(num);

		while (!queue.isEmpty()) {

			num = queue.poll();

			if (num <= x) {
				System.out.println(num);

				int lastDigit = num % 10;

				if (lastDigit == 0) {

					queue.add((num * 10) + (lastDigit + 1));

				} else if (lastDigit == 9) {

					queue.add((num * 10) + (lastDigit - 1));
				} else {
					queue.add((num * 10) + (lastDigit - 1));
					queue.add((num * 10) + (lastDigit + 1));
				}

			}

		}

	}

}
