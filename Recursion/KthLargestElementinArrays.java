package Recursion;

import java.util.Random;

public class KthLargestElementinArrays {
	int nums[];
	Random rand = new Random();

	public int findKthLargest(int[] nums, int k) {
		this.nums = nums;
		return quickSelect(0, nums.length - 1, nums.length - k);
	}

	int quickSelect(int left, int right, int kSmallest) {
		while (true) {
			if (left >= right)
				return nums[left];

			int partIdx = left + rand.nextInt(right - left);

			partIdx = partition(left, right, partIdx);
			if (kSmallest == partIdx) {
				break;
			} else if (kSmallest < partIdx) {
				right = partIdx - 1;
			} else {
				left = partIdx + 1;
			}
		}
		return nums[kSmallest];
	}

	int partition(int l, int r, int pivotIdx) {
		int pivotVal = nums[pivotIdx];
		swap(pivotIdx, r);

		int saveIdx = l;
		for (int i = l; i < r; i++) {
			if (nums[i] < pivotVal) {
				swap(saveIdx++, i);
			}
		}
		swap(saveIdx, r);
		return saveIdx;
	}

	void swap(int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
}
