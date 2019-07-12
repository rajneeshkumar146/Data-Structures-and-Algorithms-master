package Recursion;

public class power {

	public static void main(String[] args) {
		powerfinder(2, 3);

	}

	public static int powerfinder(int x, int n) {

		if (n == 0) {
			return 1;
		}

		int xpnm1 = powerfinder(x, n - 1);
		int xpn = xpnm1 * x;

		return xpn;
	}

}
