package Recursion;

public class reachable_N_by_0_1_Fibonacci {

	public static void main(String[] args) {

		System.out.println(func(41));

	}

	public static boolean func(int n) {

		return isSqrt(5 * n * n + 4) || isSqrt(5 * n * n - 4);
	}

	private static boolean isSqrt(int x) {

		if (x == 0 || x == 1) {
			return true;
		}

		if (x == 4) {
			return true;
		}

		int left = 1;

		int right = x / 2;

		while (right >= left) {
			int mid = (left + right) / 2;

			if ((mid * mid) == x) {
				return true;
			}

			if ((mid * mid) < x) {
				left = mid + 1;

			} else {

				right = mid - 1;
			}

		}

		return false;
	}

}
