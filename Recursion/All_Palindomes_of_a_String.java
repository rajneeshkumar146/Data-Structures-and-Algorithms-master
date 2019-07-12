package Recursion;

public class All_Palindomes_of_a_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "abbaeae";

		func(str);

	}

	public static void func(String str) {
		String temp = "";

		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				temp = str.substring(i, j);

				if (temp.length() >= 2) {

					if (Check(temp)) {
						System.out.println(temp);

					}
				}

			}
		}
	}

	private static boolean Check(String str) {

		int i = 0;
		int j = str.length() - 1;

		while (i < j) {

			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}

			i++;
			j--;

		}

		return true;

	}

}
