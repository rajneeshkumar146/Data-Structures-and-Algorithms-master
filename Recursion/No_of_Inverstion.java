package Recursion;

public class No_of_Inverstion {

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 20, 6, 4, 5 };

		System.out.println(inversion(arr));
	}

	public static int inversion(int[] arr) {
		return CountInversion(arr, 0, arr.length - 1);
	}

	public static int CountInversion(int arr[], int left, int right) {
		int mid, inv_count = 0;
		if (right > left) {

			mid = (right + left) / 2;

			inv_count = CountInversion(arr, left, mid);

			inv_count += CountInversion(arr, mid + 1, right);

			inv_count += MergeSorted(arr, left, mid + 1, right);
		}
		return inv_count;
	}

	private static int MergeSorted(int[] arr, int left, int mid, int right) {

		int[] temp = new int[arr.length];
		int i, j, k;
		int inv_count = 0;

		i = left;
		j = mid;
		k = left;
		while ((i <= mid - 1) && (j <= right)) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];

				inv_count = inv_count + (mid - i);
			}
		}

		while (i <= mid - 1)
			temp[k++] = arr[i++];

		while (j <= right)
			temp[k++] = arr[j++];

		for (i = left; i <= right; i++)
			arr[i] = temp[i];

		return inv_count;
	}

}
