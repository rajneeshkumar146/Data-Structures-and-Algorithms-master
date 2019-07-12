package Recursion;

import java.util.*;

public class Majority_element_Moore_Voting_Algo {

	public static int majorityElement(int[] arr) {

		int m = arr[0];
		int mctr = 1;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == m) {
				mctr++;
			} else if (arr[i] != m) {
				if (mctr == 0) {
					m = arr[i];
					mctr = 1;
				} else {
					mctr -= 1;
				}
			}
		}

		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == m) {
				ans++;
			}
		}

		if (ans > arr.length / 2) {
			return ans;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(majorityElement(arr));
	}
}
