package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class Max_No_Points_on_Line {

	public static int maxPoints(Point[] points) {

		HashMap<Point, Integer> map = new HashMap<Point, Integer>();
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < points.length; i++) {

			for (int j = i + 1; j < points.length; j++) {

				Point XY = points[i];

				Point XY2 = points[j];

				int dx = XY2.x - XY.x;
				int dy = XY2.y - XY.y;

				int gcd = gcd(dx, dy);

				dx = dx / gcd;

				dy = dy / gcd;

				Point temp = new Point(dx, dy);
				map.put(temp, map.containsKey(temp) ? map.get(temp) + 1 : 2);

				max = Math.max(max, map.get(temp));

			}
			map.clear();
		}
		return max;
	}

	private static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}

	static class Point {

		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			return this.x + this.y;
		}

		public boolean equals(Object o) {
			Point O = (Point) o;

			if (this.x == O.x && this.y == O.y)
				return true;
			return false;
		}
	}

	public static void main(String[] args) {

//		6
//		1 1 3 2 5 3 4 1 2 3 1 4
//		4

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Point[] points = new Point[N];
		for (int i = 0; i < N; i++) {
			points[i] = new Point(sc.nextInt(), sc.nextInt());
		}
		System.out.println(maxPoints(points));
	}
}