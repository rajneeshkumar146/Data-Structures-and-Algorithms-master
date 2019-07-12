package Recursion;

public class square_Root {
	public static void main(String[] args) {
		System.out.println(func(64));
	}

	public static int func(int x) {

		if (x == 0 || x == 1) {
			return x;
		}

		if (x == 4) {
			return 2;
		}

		int start = 1;
		int end = x / 2;

		while (start <= end) {
			int mid = (start + end) / 2;

			if (mid * mid == x) {
				return mid;
			}

			if ((mid * mid) < x) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}

		}

		return 0;
	}

}