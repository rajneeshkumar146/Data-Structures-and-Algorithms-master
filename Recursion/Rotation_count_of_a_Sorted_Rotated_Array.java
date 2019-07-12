package Recursion;

public class Rotation_count_of_a_Sorted_Rotated_Array {
	public static void main(String[] args) {

		int arr[] = { 7, 9, 11, 12, 5 };

		System.out.println(rotationCount(arr, 0, arr.length - 1));
	}

	private static int rotationCount(int[] arr, int low, int high) {

		if (high < low) {
			return 0;
		}

		if (high == low) {
			return low;
		}

		int mid = (low + high) / 2;

		if (mid < high && arr[mid + 1] < arr[mid]) {
			return mid + 1;
		}

		if (mid > low && arr[mid] < arr[mid - 1]) {
			return mid;
		}

		if (arr[high] > arr[mid]) {
			return rotationCount(arr, low, mid - 1);
		}

		return rotationCount(arr, mid + 1, high);
	}
}
