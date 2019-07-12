package Recursion;

public class MedianOfUnequalSortedArray {

	public static void main(String[] args) {
		int[] arr = { 23, 26, 31, 35 };
		int[] arr2 = { 3, 5, 7, 9, 11, 16 };

		System.out.println(func(arr, arr2));
		System.out.println(findMedianSortedArrays(arr, arr2));
	}

	private static double func(int[] inputX, int[] inputY) {

		if (inputX.length > inputY.length) {
			return func(inputY, inputX);
		}

		int x = inputX.length;
		int y = inputY.length;

		int low = 0;
		int high = x;

		while (low <= high) {
			int partitionX = (low + high) / 2;
			int partitionY = (x + y + 1) / 2 - partitionX;

			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : inputX[partitionX - 1];
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : inputX[partitionX];

			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : inputY[partitionY - 1];
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : inputY[partitionY];

			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				if ((x + y) % 2 == 0) {
					return (double) (Math.max(maxLeftY, maxLeftX) + Math.min(minRightY, minRightX)) / 2;
				} else {
					return (double) Math.max(maxLeftX, maxLeftY);
				}

			} else if (maxLeftX > minRightY) {
				high = partitionX - 1;

			} else {
				low = partitionX + 1;

			}
		}

		throw new IllegalAccessError();
	}

	public static double findMedianSortedArrays(int input1[], int input2[]) {
		if (input1.length > input2.length) {
			return findMedianSortedArrays(input2, input1);
		}
		int x = input1.length;
		int y = input2.length;

		int low = 0;
		int high = x;
		while (low <= high) {
			int partitionX = (low + high) / 2;
			int partitionY = (x + y + 1) / 2 - partitionX;

			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];

			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				if ((x + y) % 2 == 0) {
					return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
				} else {
					return (double) Math.max(maxLeftX, maxLeftY);
				}
			} else if (maxLeftX > minRightY) { // we are too far on right side for partitionX. Go on left side.
				high = partitionX - 1;
			} else { // we are too far on left side for partitionX. Go on right side.
				low = partitionX + 1;
			}
		}

		throw new IllegalArgumentException();
	}
}
