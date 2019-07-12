package Recursion;

public class TowerOfHonai {

	public static void TOH(String src, String des, String helper, int n) {

		if (n == 0) {
			return;
		}

		TOH(src, helper, des, n - 1);

		System.out.println("Move " + n + "th Disc From " + src + "to" + des);

		TOH(helper, des, src, n - 1);	

	}

	public static void Main(String[] args) {

		TOH("A", "B", "C", 3);

	}

}
