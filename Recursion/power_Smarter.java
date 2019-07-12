package Recursion;

public class power_Smarter {

	public static void main(String[] args) {
		System.out.println(powLog(2, 6));
	}

	public static int powLog(int x, int y) {
		if (y == 0) {
			return 1;
		}
		int temp = powLog(x, y / 2);

		if (y % 2 == 0) {
			return temp * temp;
		} else {
			return x * temp * temp;
		}
	}

}
