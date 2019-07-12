package Recursion;

public class Stairs_with_only_number {

	public static void main(String[] args) {

		System.out.println(func(4));
		System.out.println(funcOG(4));
	}

	public static int func(int n) {
		int[] ans = new int[n + 1];

		ans[0] = 1;
		ans[1] = 1;

		for (int i = 2; i <= n; i++) {

			ans[i] += ans[i - 2] + ans[i - 1];
		}
		return ans[n];
	}

	public static int funcOG(int n) {
		if (n == 0) {
			return 1;
		}
		return (1 << (n - 1));
	}

}
