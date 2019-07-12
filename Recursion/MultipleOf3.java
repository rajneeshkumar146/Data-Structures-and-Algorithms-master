package Recursion;

public class MultipleOf3 {
	public static void main(String[] args) {

		int n = 1000233455;

		if (func(n) != 0)
			System.out.println(n + " is multiple of 3");
		else
			System.out.println(n + " is not a multiple of 3");
	}

	public static int func(int n) {

		int evenctr = 0;
		int oddctr = 0;

		if (n < 0) {
			n = -n;
		}

		if (n == 0) {
			return 1;
		}

		if (n == 1) {
			return 0;
		}

		while (n != 0) {
			if ((n & 1) != 0) {
				oddctr++;
			}
			if ((n & 2) != 0) {
				evenctr++;
			}

			n = n >> 2;
		}

		return func(Math.abs(oddctr - evenctr));

	}
}
