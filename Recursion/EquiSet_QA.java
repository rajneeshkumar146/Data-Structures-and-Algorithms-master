package Recursion;

public class EquiSet_QA {

	public static void main(String[] args) {

		int[] arr = { 10, 20, 30, 40, 50, 60, 70 };

		func(arr, 0, "", 0, "", 0);

	}

	public static void func(int[] arr, int sum1, String str1, int sum2, String str2, int i) {

		if (i == arr.length) {
			if (sum1 == sum2) {
				System.out.println();
				System.out.println(str1 + " :- " + sum1);
				System.out.println(str2 + " :- " + sum2);
				System.out.println();
			}

			return;
		}

		func(arr, sum1 + arr[i], str1 + " " + arr[i], sum2, str2, i);

		func(arr, sum1, str1, sum2 + arr[i], str2 + " " + arr[i], i);

	}

}
