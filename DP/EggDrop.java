package DP;

public class EggDrop {

	public static void main(String[] args) {
		int eggs = 2;

		int floors = 999;

		System.out.println(eggDrop(eggs, floors, new int[eggs + 1][floors + 1]));

	}

	public static int eggDrop(int eggs, int floor, int qb[][]) {

		if (eggs == 1) {
			return floor;
		}

		if (floor == 0) {
			return 0;
		}

		if (floor == 1) {
			return 1;
		}

		if (qb[eggs][floor] != 0) {
			return qb[eggs][floor];
		}

		int minTrail = Integer.MAX_VALUE;
		for (int i = 1; i <= floor; i++) {

			int eggbreak = eggDrop(eggs - 1, i - 1, qb);
			int eggsurvive = eggDrop(eggs, floor - i, qb);

			minTrail = Math.min(Math.max(eggbreak, eggsurvive), minTrail);

		}

		qb[eggs][floor] = minTrail + 1;

		return minTrail + 1;
	}

}
