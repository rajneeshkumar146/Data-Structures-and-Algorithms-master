package Recursion;

public class Area_of_Intersection_of_Rectangle {

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) {

		func(new Pair(2, 1), new Pair(5, 5), new Pair(3, 2), new Pair(5, 7));

	}

	public static void func(Pair r1b, Pair r1t, Pair r2b, Pair r2t) {

		System.out.println(Math.max(r1b.x, r2b.x) * Math.max(r1t.x, r2t.x));

	}

}
