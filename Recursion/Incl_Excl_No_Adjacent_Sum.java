package Recursion;

public class Incl_Excl_No_Adjacent_Sum {

	public static int func(int[] arr, int n) {

		int incl = arr[0];
		int excl = 0;
		int excl_new = 0;

		for (int i = 1; i < arr.length; i++) {

			excl_new = Math.max(excl, incl);
			incl = excl + arr[i];
			excl = excl_new;
		}

		return (excl > incl) ? excl : incl;

	}

	public static void main(String[] args) {

		int[] arr = { 5, 5, 10, 100, 10, 5 };

		System.out.println(func(arr, arr.length));
	}

}
