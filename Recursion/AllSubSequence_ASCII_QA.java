package Recursion;

public class AllSubSequence_ASCII_QA {

	public static void main(String[] args) {

		AAllSubSequence_QA_ASCII("abc", "");
		

	}

	private static void AAllSubSequence_QA_ASCII(String str, String ans) {

		if (str.length() == 0) {
			System.out.println(ans);

			return;
		}

		char ch = str.charAt(0);

		String ros = str.substring(1);

		AAllSubSequence_QA_ASCII(ros, ans + ch);

		AAllSubSequence_QA_ASCII(ros, ans + (int) ch);

		AAllSubSequence_QA_ASCII(ros, ans + "_");

	}

}
