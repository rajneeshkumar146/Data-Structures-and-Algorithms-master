package Recursion;

public class Kadans_Algo {

	public static void main(String[] args) {
		int[] arr = { -5, 2 - 1, 3, 6, -11, 8, 9, -8, 5, 6, -4, -5 };

		func(arr);

	}

	public static void func(int[] arr) {

		int sum = arr[0];
		int sp = 0;
		int ep = 0;

		int Msum = arr[0];
		int s = 0;
		int e = 0;

		for (int i = 0; i < arr.length; i++) {

			if (sum > 0) {
				sum += arr[i];
				ep++;
			} else {
				sum = arr[i];

				ep = sp = i;

			}

			if (sum > Msum) {
				Msum = sum;
				s = sp;
				e = ep;
			}

		}

		for (int i = s; i <= e; i++) {

			System.out.print(arr[i] + " ");

		}

		System.out.println();

		System.out.println(Msum);
	}

}
