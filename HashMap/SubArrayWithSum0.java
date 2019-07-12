package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class SubArrayWithSum0 {

	public static void main(String[] args) {

//			6
//			-4 -1 1 10 -11 2
		Scanner scn = new Scanner(System.in);

		int size = scn.nextInt();

		long[] arr = new long[size];

		for (int j = 0; j < size; j++) {
			arr[j] = scn.nextLong();
		}

		zerosumarr(arr);

	}

	static void zerosumarr(long[] arr) {
		// Write your code here

		HashMap<Integer, Integer> map = new HashMap<>();

		int MasterSum = 0;
		int ctr = 0;

		map.put(0, 1);

		for (int i = 0; i < arr.length; i++) {

			MasterSum += (long) arr[i];

			if (map.containsKey(MasterSum)) {
				if (map.get(MasterSum) >= 1) {
					ctr += map.get(MasterSum);
				}
				map.put(MasterSum, map.get(MasterSum) + 1);
			} else {
				map.put(MasterSum, 1);
			}

		}

		System.out.println(ctr);

	}
}