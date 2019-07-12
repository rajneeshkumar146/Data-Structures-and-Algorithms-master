package Recursion;

public class Find_Unique {

	public static void main(String[] args) {
		int[] arr = { 5, 9, 9, 7, 8, 7, 5 };

		func(arr);
	}

	public static void func(int[] arr) {
		int x = 0;

		for (int val : arr) {
			x = x ^ val;

		}

		System.out.println(x);
	}

}
