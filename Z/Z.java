package Z;

public class Z {

	public static void main(String[] args) {

		String s = "qwertyuiopasdfghjklzxcvbnmmnbvcxzlkjhgfdsapoiuytrewqqwertyuiopasdfghjklZxcvbnm";

		String p = "asd";

		patternMatching(s, p);

	}

	public static void patternMatching(String s, String p) {

		String con = p + "$" + s;

		Integer[] z = preprocessing(con);

		for (int i = 1; i < z.length; i++) {

			if (z[i] == p.length())

			{
				System.out.println(p + " - > " + (i - p.length() - 1));
			}

		}
	}

	private static Integer[] preprocessing(String con) {

		Integer[] z = new Integer[con.length()];

		int l = 0;
		int r = 0;

		for (int i = 1; i < z.length; i++) {

			if (i > r) { // BruteForce
				l = i;
				r = i;

				while (r < z.length && con.charAt(r) == con.charAt(r - l)) {
					r++;
				}

				r--;
				z[i] = r - l + 1;

			} else {

				int k = i - l; // SmartWay

				if (z[k] < r - i + 1) {

					z[i] = z[k];

				} else {
					
					
					while (r < z.length && con.charAt(r) == con.charAt(r - l)) { // BruteForce
						r++;
					}

					r--;
					z[i] = r - l + 1;
				}
			}

		}
		return z;
	}
}
