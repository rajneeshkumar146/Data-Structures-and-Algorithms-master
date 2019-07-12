package Recursion;

public class Find_Uniqe_in3s {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 5, 5, 5, 6, 6, 6, 2, 7, 7, 7, };

		func(arr);
	}

	public static void func(int[] arr) {

		int uni = 0;
		for (int i = 0; i < 32; i++) {

			int bm = 1 << i;
    
			int count = 0;

			for (int val : arr) {
				if ((val & bm) == bm) {
					count++;
				}
			}

			if (count % 3 == 1) {
				uni = uni | 1 << i;
			}

		}

		System.out.println(uni);
	}

}
