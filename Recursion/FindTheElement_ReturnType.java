package Recursion;

public class FindTheElement_ReturnType {

	public static int FTH_RT(int[] arr, int n, int vidx) {

		if (vidx == arr.length - 1) {

			return -1;
		}

		if (arr[vidx] == n) {
			return vidx + 1;
		}

		int ans = FTH_RT(arr, n, vidx + 1);

		if (ans == -1) {
			return -1;
		} else {
			return ans;
		}

	}

	public static int lastindex(int[] arr, int vidx, int data) {
		if (vidx == arr.length) {
			return -1;
		}
		int val = lastindex(arr, vidx + 1, data);
		if (val != -1) {
			return val;
		} else if (arr[vidx] == data) {
			return vidx;
		} else {
			return -1;
		}

	}

	public static void main(String[] args) {

		int[] arr = { 9, 8, 7, 4, 2, 6, 3, 2, 1 };

		System.out.println(FTH_RT(arr, 2, 0));
		
		System.out.println();

		System.out.println(lastindex(arr, 0, 2));

	}
}
