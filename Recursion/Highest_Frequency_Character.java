package Recursion;

public class Highest_Frequency_Character {

	public static void func(String str) {

		int[] arr = new int[26];

		for (int i = 0; i < str.length(); i++) {

			arr[str.charAt(i) - 'a']++;

		}

		int max = Integer.MIN_VALUE;

		int chmax = 0;

		for (int i = 0; i < arr.length; i++) {

			if (max < arr[i]) {
				max = arr[i];
				chmax = i;
			}

		}

		System.out.println((char) (chmax + 'a'));

	}

	public static void main(String[] args) {

		String str = "abckdsbvksddddddddddddddddddddddddddddkwndkviwh";

		func(str);

	}

}
