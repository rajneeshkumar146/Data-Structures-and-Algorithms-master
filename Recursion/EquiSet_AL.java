package Recursion;

import java.util.ArrayList;

public class EquiSet_AL {

	public static void main(String[] args) {

		int[] arr = { 10, 20, 30, 40, 50, 60, 70 };

		EquiSet_AL(arr, 0, new ArrayList<>(), new ArrayList<>(), 0, 0);

	}

	public static void EquiSet_AL(int[] arr, int idx, ArrayList<Integer> l1, ArrayList<Integer> l2, int s1, int s2) {

		if (idx >= arr.length) {

			if (s1 == s2) {

				System.out.println("1 : - " + l1);

				System.out.println("2 : - " + l2);

				System.out.println();

			}
			return;
		}

		l1.add(arr[idx]);

		EquiSet_AL(arr, idx + 1, l1, l2, s1 + arr[idx], s2);

		l1.remove(l1.size() - 1);

		l2.add(arr[idx]);

		EquiSet_AL(arr, idx + 1, l1, l2, s1, s2 + arr[idx]);

		l2.remove(l2.size() - 1);
	}

}
