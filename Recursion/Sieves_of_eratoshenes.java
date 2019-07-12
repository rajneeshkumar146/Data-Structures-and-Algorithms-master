package Recursion;

import java.util.Arrays;

public class Sieves_of_eratoshenes {

	public static void main(String[] args) {
		soe(100);
	}

	public static void soe(int num) {

		boolean[] arr = new boolean[num + 1];
		Arrays.fill(arr, true);

		arr[0] = false;
		arr[1] = false;

		for (int i = 2; i * i <= num; i++) {

			if (arr[i]) {

				for (int j = i; i * j <= num; j++) {

					arr[i * j] = false;

				}

			}
		}

		for (int k = 0; k <= num; k++) {	

			if (arr[k]) {

				System.out.println(k);
			}

		}

	}

}