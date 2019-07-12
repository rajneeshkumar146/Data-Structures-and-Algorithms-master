package Recursion;

public class Find_Two_Unique {

	public static void main(String[] args) {
		int[] arr = { 5, 9, 9, 7, 6, 8, 7, 5 };
		func(arr);
	}

	public static void func(int[] arr) {
		int lsb = 0;

		for (int val : arr) {
			lsb = lsb ^ val;

		}

		int changer = lsb & -lsb;

		int x = 0;
		int y = 0;

		for (int val : arr) {
			if ((val & changer) == 0) {
				x = x ^ val;
			} else {
				y = y ^ val;
			}
		}
		System.out.println(x + "  " + y);
	}
}