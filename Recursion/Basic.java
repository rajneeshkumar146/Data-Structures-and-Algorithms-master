package Recursion;

public class Basic {

	public static void main(String[] args) {

		int[] arr = { 2, 8, 6, 4, 8, 6, 4, 9, 0 };

		System.out.println(FI(arr, 0, 8));
	}

	static int max = 0;

	public static int max(int[] arr, int idx) {

		if (idx == arr.length) {
			return Integer.MIN_VALUE;
		}

		int res = max(arr, idx + 1);

		if (arr[idx] > max) {
			max = arr[idx];

			return max;
		}

		return res;

	}

	public static boolean find(int[] arr, int idx, int data) {

		if (idx == arr.length) {

			return false;

		}

		if (arr[idx] == data) {
			return true;
		}

		boolean res = find(arr, idx + 1, data);

		return res;
	}

	public static int FI(int[] arr, int idx, int data) {

		if (arr.length == idx) {

			return -1;

		}

		if (arr[idx] == data) {
			return idx;
		}

		int res = FI(arr, idx + 1, data);

		return res;

	}

	public static int LI(int[] arr, int idx, int data) {

		if (arr.length == idx) {
			return -1;
		}

		int val = LI(arr, idx + 1, data);

		if (val != -1) {

			return val;
		} else if (arr[idx] == data) {

			return idx;
		} else {

			return -1;
		}

	}

	static int i = 0;

	static int[] res = new int[5000];

	public static int[] alli(int[] arr, int idx, int data, int fsf) {

		if (arr.length == idx) {

			return new int[fsf];
		}

		if (data == arr[idx]) {
			int[] res = alli(arr, idx + 1, data, fsf + 1);
			res[fsf] = idx;
			return res;

		} else {
			alli(arr, idx + 1, data, fsf);

			res[fsf] = idx;

			return res;
		}

	}

	public static void inverse(int[] arr, int idx) {

		if (idx == arr.length) {

			return;

		}

		int temp = arr[idx];

		inverse(arr, idx + 1);

		arr[temp] = idx;

	}
}
