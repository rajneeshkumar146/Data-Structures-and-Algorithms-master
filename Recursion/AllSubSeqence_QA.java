package Recursion;

public class AllSubSeqence_QA {

	public static void main(String[] args) {

		AllSubSeqence_QC("abc", "");

	}

	public static void AllSubSeqence_QC(String str, String ans) {

		if (str.length() == 0) {
			System.out.println(ans);
			
			return;
		}

		char ch = str.charAt(0);

		String ros = str.substring(1);

		AllSubSeqence_QC(ros, ans + ch);

		AllSubSeqence_QC(ros, ans + "_");

	}

}
